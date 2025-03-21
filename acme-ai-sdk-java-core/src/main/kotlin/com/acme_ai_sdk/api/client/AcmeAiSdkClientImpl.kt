// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.client

import com.acme_ai_sdk.api.core.ClientOptions
import com.acme_ai_sdk.api.core.getPackageVersion
import com.acme_ai_sdk.api.services.blocking.FileService
import com.acme_ai_sdk.api.services.blocking.FileServiceImpl

class AcmeAiSdkClientImpl(private val clientOptions: ClientOptions) : AcmeAiSdkClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: AcmeAiSdkClientAsync by lazy { AcmeAiSdkClientAsyncImpl(clientOptions) }

    private val withRawResponse: AcmeAiSdkClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): AcmeAiSdkClientAsync = async

    override fun withRawResponse(): AcmeAiSdkClient.WithRawResponse = withRawResponse

    override fun files(): FileService = files

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AcmeAiSdkClient.WithRawResponse {

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun files(): FileService.WithRawResponse = files
    }
}
