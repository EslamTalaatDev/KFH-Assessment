package com.kfh.assessment.app.ui.login
enum class AuthErrorCode { INVALID, FORBIDDEN, NETWORK, HTTP, UNKNOWN }
data class AuthException(val code: AuthErrorCode, val httpCode: Int? = null, val messageText: String? = null): Exception()
