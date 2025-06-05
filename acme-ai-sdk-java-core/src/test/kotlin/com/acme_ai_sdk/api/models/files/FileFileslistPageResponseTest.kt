// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileFileslistPageResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val fileFileslistPageResponse =
            FileFileslistPageResponse.builder()
                .addFile(
                    FileFileslistResponse.builder()
                        .completionTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .error("error")
                        .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fileSize(0L)
                        .filename("filename")
                        .status(FileFileslistResponse.Status.PENDING)
                        .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .limit(0L)
                .offset(0L)
                .total(0L)
                .build()

        assertThat(fileFileslistPageResponse.files().getOrNull())
            .containsExactly(
                FileFileslistResponse.builder()
                    .completionTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .error("error")
                    .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .fileSize(0L)
                    .filename("filename")
                    .status(FileFileslistResponse.Status.PENDING)
                    .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(fileFileslistPageResponse.limit()).contains(0L)
        assertThat(fileFileslistPageResponse.offset()).contains(0L)
        assertThat(fileFileslistPageResponse.total()).contains(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileFileslistPageResponse =
            FileFileslistPageResponse.builder()
                .addFile(
                    FileFileslistResponse.builder()
                        .completionTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .error("error")
                        .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fileSize(0L)
                        .filename("filename")
                        .status(FileFileslistResponse.Status.PENDING)
                        .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .limit(0L)
                .offset(0L)
                .total(0L)
                .build()

        val roundtrippedFileFileslistPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileFileslistPageResponse),
                jacksonTypeRef<FileFileslistPageResponse>(),
            )

        assertThat(roundtrippedFileFileslistPageResponse).isEqualTo(fileFileslistPageResponse)
    }
}
