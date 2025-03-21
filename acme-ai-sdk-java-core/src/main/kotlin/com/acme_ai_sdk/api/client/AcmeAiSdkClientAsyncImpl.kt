// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.client

import com.acme_ai_sdk.api.core.ClientOptions
import com.acme_ai_sdk.api.core.getPackageVersion
import com.acme_ai_sdk.api.services.async.FileServiceAsync
import com.acme_ai_sdk.api.services.async.FileServiceAsyncImpl

class AcmeAiSdkClientAsyncImpl(private val clientOptions: ClientOptions) : AcmeAiSdkClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: AcmeAiSdkClient by lazy { AcmeAiSdkClientImpl(clientOptions) }

    private val withRawResponse: AcmeAiSdkClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): AcmeAiSdkClient = sync

    override fun withRawResponse(): AcmeAiSdkClientAsync.WithRawResponse = withRawResponse

    override fun files(): FileServiceAsync = files

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AcmeAiSdkClientAsync.WithRawResponse {

        private val files: FileServiceAsync.WithRawResponse by lazy {
            FileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun files(): FileServiceAsync.WithRawResponse = files
    }
}
