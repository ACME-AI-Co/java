// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileFileCreateResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val fileFileCreateResponse =
            FileFileCreateResponse.builder()
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .status(FileFileCreateResponse.Status.PENDING)
                .uploadTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(fileFileCreateResponse.fileId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(fileFileCreateResponse.status()).contains(FileFileCreateResponse.Status.PENDING)
        assertThat(fileFileCreateResponse.uploadTime())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }
}
