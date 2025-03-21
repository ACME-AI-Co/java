// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.services.blocking

import com.acme_ai_sdk.api.core.ClientOptions
import com.acme_ai_sdk.api.core.JsonValue
import com.acme_ai_sdk.api.core.RequestOptions
import com.acme_ai_sdk.api.core.handlers.errorHandler
import com.acme_ai_sdk.api.core.handlers.jsonHandler
import com.acme_ai_sdk.api.core.handlers.withErrorHandler
import com.acme_ai_sdk.api.core.http.HttpMethod
import com.acme_ai_sdk.api.core.http.HttpRequest
import com.acme_ai_sdk.api.core.http.HttpResponse.Handler
import com.acme_ai_sdk.api.core.http.HttpResponseFor
import com.acme_ai_sdk.api.core.http.multipartFormData
import com.acme_ai_sdk.api.core.http.parseable
import com.acme_ai_sdk.api.core.prepare
import com.acme_ai_sdk.api.models.files.FileFileCreateParams
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse
import com.acme_ai_sdk.api.models.files.FileFileSearchParams
import com.acme_ai_sdk.api.models.files.FileFileSearchResponse
import com.acme_ai_sdk.api.models.files.FileFileslistParams
import com.acme_ai_sdk.api.models.files.FileFileslistResponse

class FileServiceImpl internal constructor(private val clientOptions: ClientOptions) : FileService {

    private val withRawResponse: FileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FileService.WithRawResponse = withRawResponse

    override fun fileCreate(
        params: FileFileCreateParams,
        requestOptions: RequestOptions,
    ): FileFileCreateResponse =
        // post /files/
        withRawResponse().fileCreate(params, requestOptions).parse()

    override fun fileSearch(
        params: FileFileSearchParams,
        requestOptions: RequestOptions,
    ): FileFileSearchResponse =
        // get /files/{file_id}/search
        withRawResponse().fileSearch(params, requestOptions).parse()

    override fun fileslist(
        params: FileFileslistParams,
        requestOptions: RequestOptions,
    ): FileFileslistResponse =
        // get /files/
        withRawResponse().fileslist(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FileService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val fileCreateHandler: Handler<FileFileCreateResponse> =
            jsonHandler<FileFileCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun fileCreate(
            params: FileFileCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FileFileCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("files", "")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { fileCreateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<FileFileSearchResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("files", params._pathParam(0), "search")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { fileSearchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<FileFileslistResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("files", "")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
