@file:JvmName("JsonHandler")

package com.acme_ai_sdk.api.core.handlers

import com.acme_ai_sdk.api.core.http.HttpResponse
import com.acme_ai_sdk.api.core.http.HttpResponse.Handler
import com.acme_ai_sdk.api.errors.AcmeAiSdkInvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw AcmeAiSdkInvalidDataException("Error reading response", e)
            }
    }
