@file:JvmName("StringHandler")

package com.acme_ai_sdk.api.core.handlers

import com.acme_ai_sdk.api.core.http.HttpResponse
import com.acme_ai_sdk.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
