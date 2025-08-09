package com.kfh.assessment.domain.repo
import com.kfh.assessment.domain.model.*
interface BitbucketRepository {
  suspend fun getRepositories(workspace: String, role: String = "member", pageLen: Int = 100, forceRefresh: Boolean = false): List<Repo>
  suspend fun getRepositoryDetails(workspace: String, repoSlug: String, forceRefresh: Boolean = false): RepoDetail
  suspend fun getMe(forceRefresh: Boolean = false): User
  suspend fun logoutClearAll()
}
