package com.kfh.assessment.data.api
import retrofit2.http.*

data class LinkDto(val href: String? = null)
data class LinksDto(val html: LinkDto? = null, val repositories: LinkDto? = null, val snippets: LinkDto? = null, val avatar: LinkDto? = null)
data class OwnerDto(val display_name: String? = null)
data class MainBranchDto(val name: String? = null)

data class RepoDto(
  val uuid: String,
  val name: String,
  val slug: String,
  val description: String?,
  val full_name: String,
  val is_private: Boolean? = null,
  val scm: String? = null,
  val language: String? = null,
  val size: Long? = null,
  val created_on: String? = null,
  val updated_on: String? = null,
  val links: LinksDto? = null,
  val mainbranch: MainBranchDto? = null,
  val owner: OwnerDto? = null
)
data class RepoPageDto(val values: List<RepoDto> = emptyList(), val next: String? = null)

data class UserDto(
  val uuid: String,
  val username: String?,
  val display_name: String?,
  val account_id: String?,
  val nickname: String?,
  val account_status: String?,
  val created_on: String?,
  val location: String?,
  val has_2fa_enabled: Boolean?,
  val links: LinksDto? = null
)

interface BitbucketService {
  @GET("2.0/repositories/{workspace}")
  suspend fun getRepositories(@Path("workspace") workspace: String, @Query("pagelen") pageLen: Int = 100, @Query("role") role: String = "member"): RepoPageDto

  @GET("2.0/repositories/{workspace}/{repo_slug}")
  suspend fun getRepositoryDetails(@Path("workspace") workspace: String, @Path("repo_slug") repoSlug: String): RepoDto

  @GET("2.0/user") suspend fun getMe(): UserDto
}
