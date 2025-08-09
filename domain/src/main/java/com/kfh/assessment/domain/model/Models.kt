package com.kfh.assessment.domain.model
data class Repo(val uuid: String, val name: String, val fullName: String, val slug: String, val description: String?)
data class RepoDetail(
  val uuid: String,
  val name: String,
  val fullName: String,
  val slug: String,
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
data class User(
  val uuid: String,
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
  val snippetsUrl: String?,
)
