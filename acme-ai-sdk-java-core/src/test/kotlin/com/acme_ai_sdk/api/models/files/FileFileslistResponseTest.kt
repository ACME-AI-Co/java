// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileFileslistResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val fileFileslistResponse =
            FileFileslistResponse.builder()
                .addFile(
                    FileFileslistResponse.File.builder()
                        .completionTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .error("error")
                        .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .fileSize(0L)
                        .filename("filename")
                        .status(FileFileslistResponse.File.Status.PENDING)
                        .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .limit(0L)
                .offset(0L)
                .total(0L)
                .build()

        assertThat(fileFileslistResponse.files().getOrNull())
            .containsExactly(
                FileFileslistResponse.File.builder()
                    .completionTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .error("error")
                    .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .fileSize(0L)
                    .filename("filename")
                    .status(FileFileslistResponse.File.Status.PENDING)
                    .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(fileFileslistResponse.limit()).contains(0L)
        assertThat(fileFileslistResponse.offset()).contains(0L)
        assertThat(fileFileslistResponse.total()).contains(0L)
    }
}
