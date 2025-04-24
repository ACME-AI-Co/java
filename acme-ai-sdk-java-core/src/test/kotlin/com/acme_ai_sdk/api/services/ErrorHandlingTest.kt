// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.services

import com.acme_ai_sdk.api.client.AcmeAiSdkClient
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient
import com.acme_ai_sdk.api.core.JsonValue
import com.acme_ai_sdk.api.core.http.Headers
import com.acme_ai_sdk.api.core.jsonMapper
import com.acme_ai_sdk.api.errors.AcmeAiSdkException
import com.acme_ai_sdk.api.errors.BadRequestException
import com.acme_ai_sdk.api.errors.InternalServerException
import com.acme_ai_sdk.api.errors.NotFoundException
import com.acme_ai_sdk.api.errors.PermissionDeniedException
import com.acme_ai_sdk.api.errors.RateLimitException
import com.acme_ai_sdk.api.errors.UnauthorizedException
import com.acme_ai_sdk.api.errors.UnexpectedStatusCodeException
import com.acme_ai_sdk.api.errors.UnprocessableEntityException
import com.acme_ai_sdk.api.models.files.FileFileCreateParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

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
    fun filesFileCreate400() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreate401() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreate403() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreate404() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreate422() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreate429() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreate500() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreate999() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun filesFileCreateInvalidJsonBody() {
        val fileService = client.files()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<AcmeAiSdkException> {
                fileService.fileCreate(
                    FileFileCreateParams.builder()
                        .file("some content".byteInputStream())
                        .description("description")
                        .processingOptions(
                            FileFileCreateParams.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
