// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.JsonValue
import com.acme_ai_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileFileSearchResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val fileFileSearchResponse =
            FileFileSearchResponse.builder()
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .metadata(
                    FileFileSearchResponse.Metadata.builder()
                        .description("description")
                        .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fileType("file_type")
                        .filename("filename")
                        .pageCount(0L)
                        .processingOptions(
                            FileFileSearchResponse.Metadata.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .wordCount(0L)
                        .build()
                )
                .query("query")
                .addResult(
                    FileFileSearchResponse.Result.builder()
                        .additionalContext(JsonValue.from(mapOf<String, Any>()))
                        .addHighlightRange(
                            FileFileSearchResponse.Result.HighlightRange.builder()
                                .end(0L)
                                .start(0L)
                                .build()
                        )
                        .pageNumber(0L)
                        .passage("passage")
                        .relevanceScore(0.0)
                        .build()
                )
                .totalResults(0L)
                .build()

        assertThat(fileFileSearchResponse.fileId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(fileFileSearchResponse.metadata())
            .contains(
                FileFileSearchResponse.Metadata.builder()
                    .description("description")
                    .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .fileType("file_type")
                    .filename("filename")
                    .pageCount(0L)
                    .processingOptions(
                        FileFileSearchResponse.Metadata.ProcessingOptions.builder()
                            .language("language")
                            .ocr(true)
                            .build()
                    )
                    .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .wordCount(0L)
                    .build()
            )
        assertThat(fileFileSearchResponse.query()).contains("query")
        assertThat(fileFileSearchResponse.results().getOrNull())
            .containsExactly(
                FileFileSearchResponse.Result.builder()
                    .additionalContext(JsonValue.from(mapOf<String, Any>()))
                    .addHighlightRange(
                        FileFileSearchResponse.Result.HighlightRange.builder()
                            .end(0L)
                            .start(0L)
                            .build()
                    )
                    .pageNumber(0L)
                    .passage("passage")
                    .relevanceScore(0.0)
                    .build()
            )
        assertThat(fileFileSearchResponse.totalResults()).contains(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileFileSearchResponse =
            FileFileSearchResponse.builder()
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .metadata(
                    FileFileSearchResponse.Metadata.builder()
                        .description("description")
                        .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fileType("file_type")
                        .filename("filename")
                        .pageCount(0L)
                        .processingOptions(
                            FileFileSearchResponse.Metadata.ProcessingOptions.builder()
                                .language("language")
                                .ocr(true)
                                .build()
                        )
                        .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .wordCount(0L)
                        .build()
                )
                .query("query")
                .addResult(
                    FileFileSearchResponse.Result.builder()
                        .additionalContext(JsonValue.from(mapOf<String, Any>()))
                        .addHighlightRange(
                            FileFileSearchResponse.Result.HighlightRange.builder()
                                .end(0L)
                                .start(0L)
                                .build()
                        )
                        .pageNumber(0L)
                        .passage("passage")
                        .relevanceScore(0.0)
                        .build()
                )
                .totalResults(0L)
                .build()

        val roundtrippedFileFileSearchResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileFileSearchResponse),
                jacksonTypeRef<FileFileSearchResponse>(),
            )

        assertThat(roundtrippedFileFileSearchResponse).isEqualTo(fileFileSearchResponse)
    }
}
