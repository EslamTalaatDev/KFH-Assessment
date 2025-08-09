package com.kfh.assessment.domain.usecase
import com.kfh.assessment.domain.model.*
import com.kfh.assessment.domain.repo.BitbucketRepository
class GetReposUseCase(private val repo: BitbucketRepository) { suspend operator fun invoke(workspace: String, role: String = "member", pageLen: Int = 100, forceRefresh: Boolean = false): List<Repo> = repo.getRepositories(workspace, role, pageLen, forceRefresh) }
class GetRepoDetailsUseCase(private val repo: BitbucketRepository) { suspend operator fun invoke(workspace: String, slug: String, forceRefresh: Boolean = false): RepoDetail = repo.getRepositoryDetails(workspace, slug, forceRefresh) }
class GetUserUseCase(private val repo: BitbucketRepository) { suspend operator fun invoke(forceRefresh: Boolean = false): User = repo.getMe(forceRefresh) }
class LogoutUseCase(private val repo: BitbucketRepository) { suspend operator fun invoke() = repo.logoutClearAll() }
