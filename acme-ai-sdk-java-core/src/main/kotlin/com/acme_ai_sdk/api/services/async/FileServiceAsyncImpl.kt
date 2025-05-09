// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.services.async

import com.acme_ai_sdk.api.core.ClientOptions
import com.acme_ai_sdk.api.core.JsonValue
import com.acme_ai_sdk.api.core.RequestOptions
import com.acme_ai_sdk.api.core.checkRequired
import com.acme_ai_sdk.api.core.handlers.errorHandler
import com.acme_ai_sdk.api.core.handlers.jsonHandler
import com.acme_ai_sdk.api.core.handlers.withErrorHandler
import com.acme_ai_sdk.api.core.http.HttpMethod
import com.acme_ai_sdk.api.core.http.HttpRequest
import com.acme_ai_sdk.api.core.http.HttpResponse.Handler
import com.acme_ai_sdk.api.core.http.HttpResponseFor
import com.acme_ai_sdk.api.core.http.multipartFormData
import com.acme_ai_sdk.api.core.http.parseable
import com.acme_ai_sdk.api.core.prepareAsync
import com.acme_ai_sdk.api.models.files.FileFileCreateParams
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse
import com.acme_ai_sdk.api.models.files.FileFileSearchParams
import com.acme_ai_sdk.api.models.files.FileFileSearchResponse
import com.acme_ai_sdk.api.models.files.FileFileslistParams
import com.acme_ai_sdk.api.models.files.FileFileslistResponse
import java.util.concurrent.CompletableFuture
import kotlin.jvm.optionals.getOrNull

class FileServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FileServiceAsync {

    private val withRawResponse: FileServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileServiceAsync.WithRawResponse = withRawResponse

    override fun fileCreate(
        params: FileFileCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileFileCreateResponse> =
        // post /files/
        withRawResponse().fileCreate(params, requestOptions).thenApply { it.parse() }

    override fun fileSearch(
        params: FileFileSearchParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileFileSearchResponse> =
        // get /files/{file_id}/search
        withRawResponse().fileSearch(params, requestOptions).thenApply { it.parse() }

    override fun fileslist(
        params: FileFileslistParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileFileslistResponse> =
        // get /files/
        withRawResponse().fileslist(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val fileCreateHandler: Handler<FileFileCreateResponse> =
            jsonHandler<FileFileCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun fileCreate(
            params: FileFileCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileFileCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("files", "")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { fileCreateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val fileSearchHandler: Handler<FileFileSearchResponse> =
            jsonHandler<FileFileSearchResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun fileSearch(
            params: FileFileSearchParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileFileSearchResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fileId", params.fileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("files", params._pathParam(0), "search")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { fileSearchHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val fileslistHandler: Handler<FileFileslistResponse> =
            jsonHandler<FileFileslistResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun fileslist(
            params: FileFileslistParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileFileslistResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("files", "")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { fileslistHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
