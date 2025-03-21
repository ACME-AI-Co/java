// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileFileslistParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        FileFileslistParams.builder()
            .limit(1L)
            .offset(0L)
            .sortBy(FileFileslistParams.SortBy.UPLOAD_TIME)
            .sortOrder(FileFileslistParams.SortOrder.ASC)
            .status(FileFileslistParams.Status.PENDING)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            FileFileslistParams.builder()
                .limit(1L)
                .offset(0L)
                .sortBy(FileFileslistParams.SortBy.UPLOAD_TIME)
                .sortOrder(FileFileslistParams.SortOrder.ASC)
                .status(FileFileslistParams.Status.PENDING)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "1")
                    .put("offset", "0")
                    .put("sort_by", "upload_time")
                    .put("sort_order", "asc")
                    .put("status", "pending")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FileFileslistParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
