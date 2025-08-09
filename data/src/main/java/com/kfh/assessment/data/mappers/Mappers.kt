package com.kfh.assessment.data.mappers
import com.kfh.assessment.data.api.RepoDto
import com.kfh.assessment.data.api.UserDto
import com.kfh.assessment.data.db.*
import com.kfh.assessment.domain.model.*

fun RepoDto.toEntity() = RepoEntity(uuid, name, full_name, slug, description)
fun RepoEntity.toDomain() = Repo(uuid, name, fullName, slug, description)

fun RepoDto.toDetailEntity() = RepoDetailEntity(
  slug = slug,
  uuid = uuid,
  name = name,
  fullName = full_name,
  description = description,
  isPrivate = is_private,
  scm = scm,
  language = language,
  size = size,
  createdOn = created_on,
  updatedOn = updated_on,
  mainBranch = mainbranch?.name,
  ownerDisplayName = owner?.display_name,
  htmlUrl = links?.html?.href
)
fun RepoDetailEntity.toDomain() = RepoDetail(
  uuid, name, fullName, slug, description, isPrivate, scm, language, size, createdOn, updatedOn, mainBranch, ownerDisplayName, htmlUrl
)

fun UserDto.toEntity() = UserEntity(
  uuid = uuid,
  username = username,
  displayName = display_name,
  accountId = account_id,
  nickname = nickname,
  accountStatus = account_status,
  createdOn = created_on,
  location = location,
  has2FA = has_2fa_enabled,
  htmlUrl = links?.html?.href,
  avatarUrl = links?.avatar?.href,
  reposUrl = links?.repositories?.href,
  snippetsUrl = links?.snippets?.href,
)

fun UserEntity.toDomain() = User(
  uuid = uuid,
  username = username,
  displayName = displayName,
  accountId = accountId,
  nickname = nickname,
  accountStatus = accountStatus,
  createdOn = createdOn,
  location = location,
  has2FA = has2FA,
  htmlUrl = htmlUrl,
  avatarUrl = avatarUrl,
  reposUrl = reposUrl,
  snippetsUrl = snippetsUrl
)
