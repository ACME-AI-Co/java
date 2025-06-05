// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.AutoPagerAsync
import com.acme_ai_sdk.api.core.PageAsync
import com.acme_ai_sdk.api.core.checkRequired
import com.acme_ai_sdk.api.services.async.FileServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

/** @see [FileServiceAsync.fileslist] */
class FileFileslistPageAsync
private constructor(
    private val service: FileServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: FileFileslistParams,
    private val response: FileFileslistPageResponse,
) : PageAsync<FileFileslistResponse> {

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

    override fun nextPage(): CompletableFuture<FileFileslistPageAsync> =
        service.fileslist(nextPageParams())

    fun autoPager(): AutoPagerAsync<FileFileslistResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): FileFileslistParams = params

    /** The response that this page was parsed from. */
    fun response(): FileFileslistPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileFileslistPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileFileslistPageAsync]. */
    class Builder internal constructor() {

        private var service: FileServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: FileFileslistParams? = null
        private var response: FileFileslistPageResponse? = null

        @JvmSynthetic
        internal fun from(fileFileslistPageAsync: FileFileslistPageAsync) = apply {
            service = fileFileslistPageAsync.service
            streamHandlerExecutor = fileFileslistPageAsync.streamHandlerExecutor
            params = fileFileslistPageAsync.params
            response = fileFileslistPageAsync.response
        }

        fun service(service: FileServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: FileFileslistParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileFileslistPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileFileslistPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileFileslistPageAsync =
            FileFileslistPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileFileslistPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "FileFileslistPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
