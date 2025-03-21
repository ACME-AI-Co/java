package com.acme_ai_sdk.api.errors

open class AcmeAiSdkException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
