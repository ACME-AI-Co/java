// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileFileslistResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val fileFileslistResponse =
            FileFileslistResponse.builder()
                .completionTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .error("error")
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .fileSize(0L)
                .filename("filename")
                .status(FileFileslistResponse.Status.PENDING)
                .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(fileFileslistResponse.completionTime())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileFileslistResponse.error()).contains("error")
        assertThat(fileFileslistResponse.fileId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(fileFileslistResponse.fileSize()).contains(0L)
        assertThat(fileFileslistResponse.filename()).contains("filename")
        assertThat(fileFileslistResponse.status()).contains(FileFileslistResponse.Status.PENDING)
        assertThat(fileFileslistResponse.uploadTime())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileFileslistResponse =
            FileFileslistResponse.builder()
                .completionTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .error("error")
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .fileSize(0L)
                .filename("filename")
                .status(FileFileslistResponse.Status.PENDING)
                .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedFileFileslistResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileFileslistResponse),
                jacksonTypeRef<FileFileslistResponse>(),
            )

        assertThat(roundtrippedFileFileslistResponse).isEqualTo(fileFileslistResponse)
    }
}
