package com.kfh.assessment.data.db
import androidx.room.*

@Entity(tableName = "repos")
data class RepoEntity(@PrimaryKey val uuid: String, val name: String, val fullName: String, val slug: String, val description: String?)

@Entity(tableName = "repo_details")
data class RepoDetailEntity(
  @PrimaryKey val slug: String,
  val uuid: String,
  val name: String,
  val fullName: String,
  val description: String?,
  val isPrivate: Boolean?,
  val scm: String?,
  val language: String?,
  val size: Long?,
  val createdOn: String?,
  val updatedOn: String?,
  val mainBranch: String?,
  val ownerDisplayName: String?,
  val htmlUrl: String?
)

@Entity(tableName = "user_me")
data class UserEntity(
  @PrimaryKey val uuid: String,
  val username: String?,
  val displayName: String?,
  val accountId: String?,
  val nickname: String?,
  val accountStatus: String?,
  val createdOn: String?,
  val location: String?,
  val has2FA: Boolean?,
  val htmlUrl: String?,
  val avatarUrl: String?,
  val reposUrl: String?,
  val snippetsUrl: String?
)

@Dao
interface RepoDao {
  @Query("DELETE FROM repos") suspend fun clear()
  @Query("SELECT * FROM repos") suspend fun getAll(): List<RepoEntity>
  @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsertAll(items: List<RepoEntity>)
}

@Dao
interface RepoDetailDao {
  @Query("DELETE FROM repo_details") suspend fun clear()
  @Query("SELECT * FROM repo_details WHERE slug = :slug LIMIT 1") suspend fun get(slug: String): RepoDetailEntity?
  @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsert(entity: RepoDetailEntity)
}

@Dao
interface UserDao {
  @Query("DELETE FROM user_me") suspend fun clear()
  @Query("SELECT * FROM user_me LIMIT 1") suspend fun get(): UserEntity?
  @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsert(user: UserEntity)
}

@Database(entities = [RepoEntity::class, RepoDetailEntity::class, UserEntity::class], version = 1, exportSchema = false)
abstract class AppDb: RoomDatabase() {
  abstract fun repoDao(): RepoDao
  abstract fun repoDetailDao(): RepoDetailDao
  abstract fun userDao(): UserDao
}
