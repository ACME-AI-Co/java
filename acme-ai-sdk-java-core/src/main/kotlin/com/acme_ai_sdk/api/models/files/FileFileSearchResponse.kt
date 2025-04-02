// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.ExcludeMissing
import com.acme_ai_sdk.api.core.JsonField
import com.acme_ai_sdk.api.core.JsonMissing
import com.acme_ai_sdk.api.core.JsonValue
import com.acme_ai_sdk.api.core.checkKnown
import com.acme_ai_sdk.api.core.toImmutable
import com.acme_ai_sdk.api.errors.AcmeAiSdkInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class FileFileSearchResponse
private constructor(
    private val fileId: JsonField<String>,
    private val metadata: JsonField<Metadata>,
    private val query: JsonField<String>,
    private val results: JsonField<List<Result>>,
    private val totalResults: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
        @JsonProperty("results")
        @ExcludeMissing
        results: JsonField<List<Result>> = JsonMissing.of(),
        @JsonProperty("total_results")
        @ExcludeMissing
        totalResults: JsonField<Long> = JsonMissing.of(),
    ) : this(fileId, metadata, query, results, totalResults, mutableMapOf())

    /**
     * Unique identifier of the searched file
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

    /**
     * File metadata (only included if requested)
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

    /**
     * The search query used
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun query(): Optional<String> = Optional.ofNullable(query.getNullable("query"))

    /**
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun results(): Optional<List<Result>> = Optional.ofNullable(results.getNullable("results"))

    /**
     * Total number of results found
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun totalResults(): Optional<Long> =
        Optional.ofNullable(totalResults.getNullable("total_results"))

    /**
     * Returns the raw JSON value of [fileId].
     *
     * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [query].
     *
     * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

    /**
     * Returns the raw JSON value of [results].
     *
     * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

    /**
     * Returns the raw JSON value of [totalResults].
     *
     * Unlike [totalResults], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total_results")
    @ExcludeMissing
    fun _totalResults(): JsonField<Long> = totalResults

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [FileFileSearchResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileFileSearchResponse]. */
    class Builder internal constructor() {

        private var fileId: JsonField<String> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var query: JsonField<String> = JsonMissing.of()
        private var results: JsonField<MutableList<Result>>? = null
        private var totalResults: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileFileSearchResponse: FileFileSearchResponse) = apply {
            fileId = fileFileSearchResponse.fileId
            metadata = fileFileSearchResponse.metadata
            query = fileFileSearchResponse.query
            results = fileFileSearchResponse.results.map { it.toMutableList() }
            totalResults = fileFileSearchResponse.totalResults
            additionalProperties = fileFileSearchResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier of the searched file */
        fun fileId(fileId: String) = fileId(JsonField.of(fileId))

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** File metadata (only included if requested) */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /** The search query used */
        fun query(query: String) = query(JsonField.of(query))

        /**
         * Sets [Builder.query] to an arbitrary JSON value.
         *
         * You should usually call [Builder.query] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun query(query: JsonField<String>) = apply { this.query = query }

        fun results(results: List<Result>) = results(JsonField.of(results))

        /**
         * Sets [Builder.results] to an arbitrary JSON value.
         *
         * You should usually call [Builder.results] with a well-typed `List<Result>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /**
         * Adds a single [Result] to [results].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
        }

        /** Total number of results found */
        fun totalResults(totalResults: Long) = totalResults(JsonField.of(totalResults))

        /**
         * Sets [Builder.totalResults] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalResults] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalResults(totalResults: JsonField<Long>) = apply { this.totalResults = totalResults }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [FileFileSearchResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileFileSearchResponse =
            FileFileSearchResponse(
                fileId,
                metadata,
                query,
                (results ?: JsonMissing.of()).map { it.toImmutable() },
                totalResults,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FileFileSearchResponse = apply {
        if (validated) {
            return@apply
        }

        fileId()
        metadata().ifPresent { it.validate() }
        query()
        results().ifPresent { it.forEach { it.validate() } }
        totalResults()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: AcmeAiSdkInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (fileId.asKnown().isPresent) 1 else 0) +
            (metadata.asKnown().getOrNull()?.validity() ?: 0) +
            (if (query.asKnown().isPresent) 1 else 0) +
            (results.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (totalResults.asKnown().isPresent) 1 else 0)

    /** File metadata (only included if requested) */
    class Metadata
    private constructor(
        private val description: JsonField<String>,
        private val fileId: JsonField<String>,
        private val fileType: JsonField<String>,
        private val filename: JsonField<String>,
        private val pageCount: JsonField<Long>,
        private val processingOptions: JsonField<ProcessingOptions>,
        private val uploadTime: JsonField<OffsetDateTime>,
        private val wordCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("file_type")
            @ExcludeMissing
            fileType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("filename")
            @ExcludeMissing
            filename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("page_count")
            @ExcludeMissing
            pageCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("processing_options")
            @ExcludeMissing
            processingOptions: JsonField<ProcessingOptions> = JsonMissing.of(),
            @JsonProperty("upload_time")
            @ExcludeMissing
            uploadTime: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("word_count")
            @ExcludeMissing
            wordCount: JsonField<Long> = JsonMissing.of(),
        ) : this(
            description,
            fileId,
            fileType,
            filename,
            pageCount,
            processingOptions,
            uploadTime,
            wordCount,
            mutableMapOf(),
        )

        /**
         * User-provided description of the file
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun description(): Optional<String> =
            Optional.ofNullable(description.getNullable("description"))

        /**
         * Unique identifier for the file
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

        /**
         * MIME type of the file
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fileType(): Optional<String> = Optional.ofNullable(fileType.getNullable("file_type"))

        /**
         * Original name of the file
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun filename(): Optional<String> = Optional.ofNullable(filename.getNullable("filename"))

        /**
         * Number of pages (for documents)
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pageCount(): Optional<Long> = Optional.ofNullable(pageCount.getNullable("page_count"))

        /**
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun processingOptions(): Optional<ProcessingOptions> =
            Optional.ofNullable(processingOptions.getNullable("processing_options"))

        /**
         * Time the file was uploaded
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun uploadTime(): Optional<OffsetDateTime> =
            Optional.ofNullable(uploadTime.getNullable("upload_time"))

        /**
         * Approximate word count
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun wordCount(): Optional<Long> = Optional.ofNullable(wordCount.getNullable("word_count"))

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [fileId].
         *
         * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        /**
         * Returns the raw JSON value of [fileType].
         *
         * Unlike [fileType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_type") @ExcludeMissing fun _fileType(): JsonField<String> = fileType

        /**
         * Returns the raw JSON value of [filename].
         *
         * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

        /**
         * Returns the raw JSON value of [pageCount].
         *
         * Unlike [pageCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("page_count") @ExcludeMissing fun _pageCount(): JsonField<Long> = pageCount

        /**
         * Returns the raw JSON value of [processingOptions].
         *
         * Unlike [processingOptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("processing_options")
        @ExcludeMissing
        fun _processingOptions(): JsonField<ProcessingOptions> = processingOptions

        /**
         * Returns the raw JSON value of [uploadTime].
         *
         * Unlike [uploadTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("upload_time")
        @ExcludeMissing
        fun _uploadTime(): JsonField<OffsetDateTime> = uploadTime

        /**
         * Returns the raw JSON value of [wordCount].
         *
         * Unlike [wordCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("word_count") @ExcludeMissing fun _wordCount(): JsonField<Long> = wordCount

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var description: JsonField<String> = JsonMissing.of()
            private var fileId: JsonField<String> = JsonMissing.of()
            private var fileType: JsonField<String> = JsonMissing.of()
            private var filename: JsonField<String> = JsonMissing.of()
            private var pageCount: JsonField<Long> = JsonMissing.of()
            private var processingOptions: JsonField<ProcessingOptions> = JsonMissing.of()
            private var uploadTime: JsonField<OffsetDateTime> = JsonMissing.of()
            private var wordCount: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                description = metadata.description
                fileId = metadata.fileId
                fileType = metadata.fileType
                filename = metadata.filename
                pageCount = metadata.pageCount
                processingOptions = metadata.processingOptions
                uploadTime = metadata.uploadTime
                wordCount = metadata.wordCount
                additionalProperties = metadata.additionalProperties.toMutableMap()
            }

            /** User-provided description of the file */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Unique identifier for the file */
            fun fileId(fileId: String) = fileId(JsonField.of(fileId))

            /**
             * Sets [Builder.fileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

            /** MIME type of the file */
            fun fileType(fileType: String) = fileType(JsonField.of(fileType))

            /**
             * Sets [Builder.fileType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileType(fileType: JsonField<String>) = apply { this.fileType = fileType }

            /** Original name of the file */
            fun filename(filename: String) = filename(JsonField.of(filename))

            /**
             * Sets [Builder.filename] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filename] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filename(filename: JsonField<String>) = apply { this.filename = filename }

            /** Number of pages (for documents) */
            fun pageCount(pageCount: Long) = pageCount(JsonField.of(pageCount))

            /**
             * Sets [Builder.pageCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pageCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pageCount(pageCount: JsonField<Long>) = apply { this.pageCount = pageCount }

            fun processingOptions(processingOptions: ProcessingOptions) =
                processingOptions(JsonField.of(processingOptions))

            /**
             * Sets [Builder.processingOptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.processingOptions] with a well-typed
             * [ProcessingOptions] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun processingOptions(processingOptions: JsonField<ProcessingOptions>) = apply {
                this.processingOptions = processingOptions
            }

            /** Time the file was uploaded */
            fun uploadTime(uploadTime: OffsetDateTime) = uploadTime(JsonField.of(uploadTime))

            /**
             * Sets [Builder.uploadTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.uploadTime] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun uploadTime(uploadTime: JsonField<OffsetDateTime>) = apply {
                this.uploadTime = uploadTime
            }

            /** Approximate word count */
            fun wordCount(wordCount: Long) = wordCount(JsonField.of(wordCount))

            /**
             * Sets [Builder.wordCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.wordCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun wordCount(wordCount: JsonField<Long>) = apply { this.wordCount = wordCount }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata =
                Metadata(
                    description,
                    fileId,
                    fileType,
                    filename,
                    pageCount,
                    processingOptions,
                    uploadTime,
                    wordCount,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
            }

            description()
            fileId()
            fileType()
            filename()
            pageCount()
            processingOptions().ifPresent { it.validate() }
            uploadTime()
            wordCount()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: AcmeAiSdkInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (fileId.asKnown().isPresent) 1 else 0) +
                (if (fileType.asKnown().isPresent) 1 else 0) +
                (if (filename.asKnown().isPresent) 1 else 0) +
                (if (pageCount.asKnown().isPresent) 1 else 0) +
                (processingOptions.asKnown().getOrNull()?.validity() ?: 0) +
                (if (uploadTime.asKnown().isPresent) 1 else 0) +
                (if (wordCount.asKnown().isPresent) 1 else 0)

        class ProcessingOptions
        private constructor(
            private val language: JsonField<String>,
            private val ocr: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("language")
                @ExcludeMissing
                language: JsonField<String> = JsonMissing.of(),
                @JsonProperty("ocr") @ExcludeMissing ocr: JsonField<Boolean> = JsonMissing.of(),
            ) : this(language, ocr, mutableMapOf())

            /**
             * Language used for processing
             *
             * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun language(): Optional<String> = Optional.ofNullable(language.getNullable("language"))

            /**
             * Whether OCR was used
             *
             * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun ocr(): Optional<Boolean> = Optional.ofNullable(ocr.getNullable("ocr"))

            /**
             * Returns the raw JSON value of [language].
             *
             * Unlike [language], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

            /**
             * Returns the raw JSON value of [ocr].
             *
             * Unlike [ocr], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("ocr") @ExcludeMissing fun _ocr(): JsonField<Boolean> = ocr

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ProcessingOptions].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ProcessingOptions]. */
            class Builder internal constructor() {

                private var language: JsonField<String> = JsonMissing.of()
                private var ocr: JsonField<Boolean> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(processingOptions: ProcessingOptions) = apply {
                    language = processingOptions.language
                    ocr = processingOptions.ocr
                    additionalProperties = processingOptions.additionalProperties.toMutableMap()
                }

                /** Language used for processing */
                fun language(language: String) = language(JsonField.of(language))

                /**
                 * Sets [Builder.language] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.language] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun language(language: JsonField<String>) = apply { this.language = language }

                /** Whether OCR was used */
                fun ocr(ocr: Boolean) = ocr(JsonField.of(ocr))

                /**
                 * Sets [Builder.ocr] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ocr] with a well-typed [Boolean] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun ocr(ocr: JsonField<Boolean>) = apply { this.ocr = ocr }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ProcessingOptions].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ProcessingOptions =
                    ProcessingOptions(language, ocr, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ProcessingOptions = apply {
                if (validated) {
                    return@apply
                }

                language()
                ocr()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: AcmeAiSdkInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (language.asKnown().isPresent) 1 else 0) +
                    (if (ocr.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ProcessingOptions && language == other.language && ocr == other.ocr && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(language, ocr, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ProcessingOptions{language=$language, ocr=$ocr, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metadata && description == other.description && fileId == other.fileId && fileType == other.fileType && filename == other.filename && pageCount == other.pageCount && processingOptions == other.processingOptions && uploadTime == other.uploadTime && wordCount == other.wordCount && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(description, fileId, fileType, filename, pageCount, processingOptions, uploadTime, wordCount, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Metadata{description=$description, fileId=$fileId, fileType=$fileType, filename=$filename, pageCount=$pageCount, processingOptions=$processingOptions, uploadTime=$uploadTime, wordCount=$wordCount, additionalProperties=$additionalProperties}"
    }

    class Result
    private constructor(
        private val additionalContext: JsonValue,
        private val highlightRanges: JsonField<List<HighlightRange>>,
        private val pageNumber: JsonField<Long>,
        private val passage: JsonField<String>,
        private val relevanceScore: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("additional_context")
            @ExcludeMissing
            additionalContext: JsonValue = JsonMissing.of(),
            @JsonProperty("highlight_ranges")
            @ExcludeMissing
            highlightRanges: JsonField<List<HighlightRange>> = JsonMissing.of(),
            @JsonProperty("page_number")
            @ExcludeMissing
            pageNumber: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("passage") @ExcludeMissing passage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("relevance_score")
            @ExcludeMissing
            relevanceScore: JsonField<Double> = JsonMissing.of(),
        ) : this(
            additionalContext,
            highlightRanges,
            pageNumber,
            passage,
            relevanceScore,
            mutableMapOf(),
        )

        /** Additional context information (document-type specific) */
        @JsonProperty("additional_context")
        @ExcludeMissing
        fun _additionalContext(): JsonValue = additionalContext

        /**
         * Character ranges to highlight within the passage
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun highlightRanges(): Optional<List<HighlightRange>> =
            Optional.ofNullable(highlightRanges.getNullable("highlight_ranges"))

        /**
         * Page number where the match was found (if applicable)
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pageNumber(): Optional<Long> =
            Optional.ofNullable(pageNumber.getNullable("page_number"))

        /**
         * Text passage containing the match with surrounding context
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun passage(): Optional<String> = Optional.ofNullable(passage.getNullable("passage"))

        /**
         * Relevance score of the result (0-1)
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun relevanceScore(): Optional<Double> =
            Optional.ofNullable(relevanceScore.getNullable("relevance_score"))

        /**
         * Returns the raw JSON value of [highlightRanges].
         *
         * Unlike [highlightRanges], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("highlight_ranges")
        @ExcludeMissing
        fun _highlightRanges(): JsonField<List<HighlightRange>> = highlightRanges

        /**
         * Returns the raw JSON value of [pageNumber].
         *
         * Unlike [pageNumber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("page_number") @ExcludeMissing fun _pageNumber(): JsonField<Long> = pageNumber

        /**
         * Returns the raw JSON value of [passage].
         *
         * Unlike [passage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("passage") @ExcludeMissing fun _passage(): JsonField<String> = passage

        /**
         * Returns the raw JSON value of [relevanceScore].
         *
         * Unlike [relevanceScore], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("relevance_score")
        @ExcludeMissing
        fun _relevanceScore(): JsonField<Double> = relevanceScore

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Result]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Result]. */
        class Builder internal constructor() {

            private var additionalContext: JsonValue = JsonMissing.of()
            private var highlightRanges: JsonField<MutableList<HighlightRange>>? = null
            private var pageNumber: JsonField<Long> = JsonMissing.of()
            private var passage: JsonField<String> = JsonMissing.of()
            private var relevanceScore: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(result: Result) = apply {
                additionalContext = result.additionalContext
                highlightRanges = result.highlightRanges.map { it.toMutableList() }
                pageNumber = result.pageNumber
                passage = result.passage
                relevanceScore = result.relevanceScore
                additionalProperties = result.additionalProperties.toMutableMap()
            }

            /** Additional context information (document-type specific) */
            fun additionalContext(additionalContext: JsonValue) = apply {
                this.additionalContext = additionalContext
            }

            /** Character ranges to highlight within the passage */
            fun highlightRanges(highlightRanges: List<HighlightRange>) =
                highlightRanges(JsonField.of(highlightRanges))

            /**
             * Sets [Builder.highlightRanges] to an arbitrary JSON value.
             *
             * You should usually call [Builder.highlightRanges] with a well-typed
             * `List<HighlightRange>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun highlightRanges(highlightRanges: JsonField<List<HighlightRange>>) = apply {
                this.highlightRanges = highlightRanges.map { it.toMutableList() }
            }

            /**
             * Adds a single [HighlightRange] to [highlightRanges].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addHighlightRange(highlightRange: HighlightRange) = apply {
                highlightRanges =
                    (highlightRanges ?: JsonField.of(mutableListOf())).also {
                        checkKnown("highlightRanges", it).add(highlightRange)
                    }
            }

            /** Page number where the match was found (if applicable) */
            fun pageNumber(pageNumber: Long) = pageNumber(JsonField.of(pageNumber))

            /**
             * Sets [Builder.pageNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pageNumber] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pageNumber(pageNumber: JsonField<Long>) = apply { this.pageNumber = pageNumber }

            /** Text passage containing the match with surrounding context */
            fun passage(passage: String) = passage(JsonField.of(passage))

            /**
             * Sets [Builder.passage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.passage] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun passage(passage: JsonField<String>) = apply { this.passage = passage }

            /** Relevance score of the result (0-1) */
            fun relevanceScore(relevanceScore: Double) =
                relevanceScore(JsonField.of(relevanceScore))

            /**
             * Sets [Builder.relevanceScore] to an arbitrary JSON value.
             *
             * You should usually call [Builder.relevanceScore] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun relevanceScore(relevanceScore: JsonField<Double>) = apply {
                this.relevanceScore = relevanceScore
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Result].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Result =
                Result(
                    additionalContext,
                    (highlightRanges ?: JsonMissing.of()).map { it.toImmutable() },
                    pageNumber,
                    passage,
                    relevanceScore,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            highlightRanges().ifPresent { it.forEach { it.validate() } }
            pageNumber()
            passage()
            relevanceScore()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: AcmeAiSdkInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (highlightRanges.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (pageNumber.asKnown().isPresent) 1 else 0) +
                (if (passage.asKnown().isPresent) 1 else 0) +
                (if (relevanceScore.asKnown().isPresent) 1 else 0)

        class HighlightRange
        private constructor(
            private val end: JsonField<Long>,
            private val start: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("end") @ExcludeMissing end: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("start") @ExcludeMissing start: JsonField<Long> = JsonMissing.of(),
            ) : this(end, start, mutableMapOf())

            /**
             * End index of highlight in passage
             *
             * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun end(): Optional<Long> = Optional.ofNullable(end.getNullable("end"))

            /**
             * Start index of highlight in passage
             *
             * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun start(): Optional<Long> = Optional.ofNullable(start.getNullable("start"))

            /**
             * Returns the raw JSON value of [end].
             *
             * Unlike [end], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("end") @ExcludeMissing fun _end(): JsonField<Long> = end

            /**
             * Returns the raw JSON value of [start].
             *
             * Unlike [start], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("start") @ExcludeMissing fun _start(): JsonField<Long> = start

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [HighlightRange]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [HighlightRange]. */
            class Builder internal constructor() {

                private var end: JsonField<Long> = JsonMissing.of()
                private var start: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(highlightRange: HighlightRange) = apply {
                    end = highlightRange.end
                    start = highlightRange.start
                    additionalProperties = highlightRange.additionalProperties.toMutableMap()
                }

                /** End index of highlight in passage */
                fun end(end: Long) = end(JsonField.of(end))

                /**
                 * Sets [Builder.end] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.end] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun end(end: JsonField<Long>) = apply { this.end = end }

                /** Start index of highlight in passage */
                fun start(start: Long) = start(JsonField.of(start))

                /**
                 * Sets [Builder.start] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.start] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun start(start: JsonField<Long>) = apply { this.start = start }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [HighlightRange].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): HighlightRange =
                    HighlightRange(end, start, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): HighlightRange = apply {
                if (validated) {
                    return@apply
                }

                end()
                start()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: AcmeAiSdkInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (end.asKnown().isPresent) 1 else 0) + (if (start.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is HighlightRange && end == other.end && start == other.start && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(end, start, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "HighlightRange{end=$end, start=$start, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Result && additionalContext == other.additionalContext && highlightRanges == other.highlightRanges && pageNumber == other.pageNumber && passage == other.passage && relevanceScore == other.relevanceScore && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalContext, highlightRanges, pageNumber, passage, relevanceScore, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Result{additionalContext=$additionalContext, highlightRanges=$highlightRanges, pageNumber=$pageNumber, passage=$passage, relevanceScore=$relevanceScore, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileFileSearchResponse && fileId == other.fileId && metadata == other.metadata && query == other.query && results == other.results && totalResults == other.totalResults && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(fileId, metadata, query, results, totalResults, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileFileSearchResponse{fileId=$fileId, metadata=$metadata, query=$query, results=$results, totalResults=$totalResults, additionalProperties=$additionalProperties}"
}
