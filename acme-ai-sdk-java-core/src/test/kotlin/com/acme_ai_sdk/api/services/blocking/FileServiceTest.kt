// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.services.blocking

import com.acme_ai_sdk.api.TestServerExtension
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient
import com.acme_ai_sdk.api.models.files.FileFileCreateParams
import com.acme_ai_sdk.api.models.files.FileFileSearchParams
import com.acme_ai_sdk.api.models.files.FileFileslistParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun fileCreate() {
        val client =
            AcmeAiSdkOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val fileService = client.files()

        val response =
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

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun fileSearch() {
        val client =
            AcmeAiSdkOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val fileService = client.files()

        val response =
            fileService.fileSearch(
                FileFileSearchParams.builder()
                    .fileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .query("query")
                    .contextSize(0L)
                    .includeMetadata(true)
                    .maxResults(1L)
                    .build()
            )

        response.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun fileslist() {
        val client =
            AcmeAiSdkOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .bearerToken("My Bearer Token")
                .build()
        val fileService = client.files()

        val response =
            fileService.fileslist(
                FileFileslistParams.builder()
                    .limit(1L)
                    .offset(0L)
                    .sortBy(FileFileslistParams.SortBy.UPLOAD_TIME)
                    .sortOrder(FileFileslistParams.SortOrder.ASC)
                    .status(FileFileslistParams.Status.PENDING)
                    .build()
            )

        response.validate()
    }
}
