// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.services

import com.acme_ai_sdk.api.client.AcmeAiSdkClient
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient
import com.acme_ai_sdk.api.models.files.FileFileCreateParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@WireMockTest
internal class ServiceParamsTest {

    private lateinit var client: AcmeAiSdkClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            AcmeAiSdkOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .bearerToken("My Bearer Token")
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun fileCreate() {
        val fileService = client.files()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        fileService.fileCreate(
            FileFileCreateParams.builder()
                .file("some content".toByteArray())
                .description("description")
                .processingOptions(
                    FileFileCreateParams.ProcessingOptions.builder()
                        .language("language")
                        .ocr(true)
                        .build()
                )
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }
}
