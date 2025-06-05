// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.AutoPager
import com.acme_ai_sdk.api.core.Page
import com.acme_ai_sdk.api.core.checkRequired
import com.acme_ai_sdk.api.services.blocking.FileService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see [FileService.fileslist] */
class FileFileslistPage
private constructor(
    private val service: FileService,
    private val params: FileFileslistParams,
    private val response: FileFileslistPageResponse,
) : Page<FileFileslistResponse> {

    /**
     * Delegates to [FileFileslistPageResponse], but gracefully handles missing data.
     *
     * @see [FileFileslistPageResponse.files]
     */
    fun files(): List<FileFileslistResponse> =
        response._files().getOptional("files").getOrNull() ?: emptyList()

    /**
     * Delegates to [FileFileslistPageResponse], but gracefully handles missing data.
     *
     * @see [FileFileslistPageResponse.total]
     */
    fun total(): Optional<Long> = response._total().getOptional("total")

    override fun items(): List<FileFileslistResponse> = files()

    override fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        val offset = params.offset().getOrDefault(0)
        val totalCount = total().getOrDefault(Long.MAX_VALUE)
        return offset + items().size < totalCount
    }

    fun nextPageParams(): FileFileslistParams {
        val offset = params.offset().getOrDefault(0)
        return params.toBuilder().offset(offset + items().size).build()
    }

    override fun nextPage(): FileFileslistPage = service.fileslist(nextPageParams())

    fun autoPager(): AutoPager<FileFileslistResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): FileFileslistParams = params

    /** The response that this page was parsed from. */
    fun response(): FileFileslistPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileFileslistPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileFileslistPage]. */
    class Builder internal constructor() {

        private var service: FileService? = null
        private var params: FileFileslistParams? = null
        private var response: FileFileslistPageResponse? = null

        @JvmSynthetic
        internal fun from(fileFileslistPage: FileFileslistPage) = apply {
            service = fileFileslistPage.service
            params = fileFileslistPage.params
            response = fileFileslistPage.response
        }

        fun service(service: FileService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FileFileslistParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileFileslistPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileFileslistPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileFileslistPage =
            FileFileslistPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileFileslistPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "FileFileslistPage{service=$service, params=$params, response=$response}"
}
