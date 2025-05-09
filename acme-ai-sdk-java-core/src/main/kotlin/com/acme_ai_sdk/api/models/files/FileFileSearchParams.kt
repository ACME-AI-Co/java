// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.Params
import com.acme_ai_sdk.api.core.checkRequired
import com.acme_ai_sdk.api.core.http.Headers
import com.acme_ai_sdk.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Search for content within a processed file using natural language queries. Returns relevant
 * passages and their context.
 */
class FileFileSearchParams
private constructor(
    private val fileId: String?,
    private val query: String,
    private val contextSize: Long?,
    private val includeMetadata: Boolean?,
    private val maxResults: Long?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun fileId(): Optional<String> = Optional.ofNullable(fileId)

    /** Natural language search query */
    fun query(): String = query

    /** Number of characters to include before and after the match */
    fun contextSize(): Optional<Long> = Optional.ofNullable(contextSize)

    /** Whether to include file metadata in response */
    fun includeMetadata(): Optional<Boolean> = Optional.ofNullable(includeMetadata)

    /** Maximum number of results to return */
    fun maxResults(): Optional<Long> = Optional.ofNullable(maxResults)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileFileSearchParams].
         *
         * The following fields are required:
         * ```java
         * .query()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileFileSearchParams]. */
    class Builder internal constructor() {

        private var fileId: String? = null
        private var query: String? = null
        private var contextSize: Long? = null
        private var includeMetadata: Boolean? = null
        private var maxResults: Long? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileFileSearchParams: FileFileSearchParams) = apply {
            fileId = fileFileSearchParams.fileId
            query = fileFileSearchParams.query
            contextSize = fileFileSearchParams.contextSize
            includeMetadata = fileFileSearchParams.includeMetadata
            maxResults = fileFileSearchParams.maxResults
            additionalHeaders = fileFileSearchParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileFileSearchParams.additionalQueryParams.toBuilder()
        }

        fun fileId(fileId: String?) = apply { this.fileId = fileId }

        /** Alias for calling [Builder.fileId] with `fileId.orElse(null)`. */
        fun fileId(fileId: Optional<String>) = fileId(fileId.getOrNull())

        /** Natural language search query */
        fun query(query: String) = apply { this.query = query }

        /** Number of characters to include before and after the match */
        fun contextSize(contextSize: Long?) = apply { this.contextSize = contextSize }

        /**
         * Alias for [Builder.contextSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun contextSize(contextSize: Long) = contextSize(contextSize as Long?)

        /** Alias for calling [Builder.contextSize] with `contextSize.orElse(null)`. */
        fun contextSize(contextSize: Optional<Long>) = contextSize(contextSize.getOrNull())

        /** Whether to include file metadata in response */
        fun includeMetadata(includeMetadata: Boolean?) = apply {
            this.includeMetadata = includeMetadata
        }

        /**
         * Alias for [Builder.includeMetadata].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun includeMetadata(includeMetadata: Boolean) = includeMetadata(includeMetadata as Boolean?)

        /** Alias for calling [Builder.includeMetadata] with `includeMetadata.orElse(null)`. */
        fun includeMetadata(includeMetadata: Optional<Boolean>) =
            includeMetadata(includeMetadata.getOrNull())

        /** Maximum number of results to return */
        fun maxResults(maxResults: Long?) = apply { this.maxResults = maxResults }

        /**
         * Alias for [Builder.maxResults].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxResults(maxResults: Long) = maxResults(maxResults as Long?)

        /** Alias for calling [Builder.maxResults] with `maxResults.orElse(null)`. */
        fun maxResults(maxResults: Optional<Long>) = maxResults(maxResults.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [FileFileSearchParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .query()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileFileSearchParams =
            FileFileSearchParams(
                fileId,
                checkRequired("query", query),
                contextSize,
                includeMetadata,
                maxResults,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> fileId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("query", query)
                contextSize?.let { put("context_size", it.toString()) }
                includeMetadata?.let { put("include_metadata", it.toString()) }
                maxResults?.let { put("max_results", it.toString()) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileFileSearchParams && fileId == other.fileId && query == other.query && contextSize == other.contextSize && includeMetadata == other.includeMetadata && maxResults == other.maxResults && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileId, query, contextSize, includeMetadata, maxResults, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "FileFileSearchParams{fileId=$fileId, query=$query, contextSize=$contextSize, includeMetadata=$includeMetadata, maxResults=$maxResults, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
