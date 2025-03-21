// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.errors

import com.acme_ai_sdk.api.core.JsonValue
import com.acme_ai_sdk.api.core.http.Headers

abstract class AcmeAiSdkServiceException
protected constructor(message: String, cause: Throwable? = null) :
    AcmeAiSdkException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
