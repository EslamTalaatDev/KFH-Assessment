package com.kfh.assessment.data.repo
import com.kfh.assessment.data.api.BitbucketService
import com.kfh.assessment.data.db.AppDb
import com.kfh.assessment.data.mappers.*
import com.kfh.assessment.domain.model.*
import com.kfh.assessment.domain.repo.BitbucketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.room.withTransaction

class BitbucketRepositoryImpl(
  private val api: BitbucketService,
  private val db: AppDb
) : BitbucketRepository {

  override suspend fun getRepositories(workspace: String, role: String, pageLen: Int, forceRefresh: Boolean): List<Repo> {
    if (!forceRefresh) {
      val cached = db.repoDao().getAll()
      if (cached.isNotEmpty()) return cached.map { it.toDomain() }
    }
    val remote = api.getRepositories(workspace, pageLen, role).values
    db.repoDao().clear()
    db.repoDao().upsertAll(remote.map { it.toEntity() })
    return db.repoDao().getAll().map { it.toDomain() }
  }

  override suspend fun getRepositoryDetails(workspace: String, repoSlug: String, forceRefresh: Boolean): RepoDetail {
    if (!forceRefresh) {
      db.repoDetailDao().get(repoSlug)?.let { return it.toDomain() }
    }
    val dto = api.getRepositoryDetails(workspace, repoSlug)
    val entity = dto.toDetailEntity()
    db.repoDetailDao().upsert(entity)
    return entity.toDomain()
  }

  override suspend fun getMe(forceRefresh: Boolean): User {
    if (!forceRefresh) {
      db.userDao().get()?.let { return it.toDomain() }
    }
    val dto = api.getMe()
    val entity = dto.toEntity()
    db.userDao().clear(); db.userDao().upsert(entity)
    return entity.toDomain()
  }

  override suspend fun logoutClearAll() {
    withContext(Dispatchers.IO) {
      db.withTransaction {
        db.repoDao().clear()
        db.repoDetailDao().clear()
        db.userDao().clear()
      }
    }
  }
}
