// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FileFileSearchParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        FileFileSearchParams.builder()
            .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .query("query")
            .contextSize(0L)
            .includeMetadata(true)
            .maxResults(1L)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun pathParams() {
        val params =
            FileFileSearchParams.builder()
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .query("query")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParams() {
        val params =
            FileFileSearchParams.builder()
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .query("query")
                .contextSize(0L)
                .includeMetadata(true)
                .maxResults(1L)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("query", "query")
                    .put("context_size", "0")
                    .put("include_metadata", "true")
                    .put("max_results", "1")
                    .build()
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            FileFileSearchParams.builder()
                .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .query("query")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("query", "query").build())
    }
}
