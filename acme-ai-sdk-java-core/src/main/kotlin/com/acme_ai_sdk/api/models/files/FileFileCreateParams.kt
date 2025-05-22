// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.ExcludeMissing
import com.acme_ai_sdk.api.core.JsonValue
import com.acme_ai_sdk.api.core.MultipartField
import com.acme_ai_sdk.api.core.Params
import com.acme_ai_sdk.api.core.checkRequired
import com.acme_ai_sdk.api.core.http.Headers
import com.acme_ai_sdk.api.core.http.QueryParams
import com.acme_ai_sdk.api.core.toImmutable
import com.acme_ai_sdk.api.errors.AcmeAiSdkInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.InputStream
import java.nio.file.Path
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.io.path.inputStream
import kotlin.io.path.name

/**
 * Upload a file for processing with AI. The file will be analyzed and made searchable using natural
 * language queries.
 */
class FileFileCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The file to upload
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun file(): InputStream = body.file()

    /**
     * Optional description of the file
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun processingOptions(): Optional<ProcessingOptions> = body.processingOptions()

    /**
     * Returns the raw multipart value of [file].
     *
     * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _file(): MultipartField<InputStream> = body._file()

    /**
     * Returns the raw multipart value of [description].
     *
     * Unlike [description], this method doesn't throw if the multipart field has an unexpected
     * type.
     */
    fun _description(): MultipartField<String> = body._description()

    /**
     * Returns the raw multipart value of [processingOptions].
     *
     * Unlike [processingOptions], this method doesn't throw if the multipart field has an
     * unexpected type.
     */
    fun _processingOptions(): MultipartField<ProcessingOptions> = body._processingOptions()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileFileCreateParams].
         *
         * The following fields are required:
         * ```java
         * .file()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileFileCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fileFileCreateParams: FileFileCreateParams) = apply {
            body = fileFileCreateParams.body.toBuilder()
            additionalHeaders = fileFileCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = fileFileCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [file]
         * - [description]
         * - [processingOptions]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The file to upload */
        fun file(file: InputStream) = apply { body.file(file) }

        /**
         * Sets [Builder.file] to an arbitrary multipart value.
         *
         * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun file(file: MultipartField<InputStream>) = apply { body.file(file) }

        /** The file to upload */
        fun file(file: ByteArray) = apply { body.file(file) }

        /** The file to upload */
        fun file(file: Path) = apply { body.file(file) }

        /** Optional description of the file */
        fun description(description: String) = apply { body.description(description) }

        /**
         * Sets [Builder.description] to an arbitrary multipart value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: MultipartField<String>) = apply {
            body.description(description)
        }

        fun processingOptions(processingOptions: ProcessingOptions) = apply {
            body.processingOptions(processingOptions)
        }

        /**
         * Sets [Builder.processingOptions] to an arbitrary multipart value.
         *
         * You should usually call [Builder.processingOptions] with a well-typed [ProcessingOptions]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun processingOptions(processingOptions: MultipartField<ProcessingOptions>) = apply {
            body.processingOptions(processingOptions)
        }

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
         * Returns an immutable instance of [FileFileCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .file()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileFileCreateParams =
            FileFileCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        mapOf(
                "file" to _file(),
                "description" to _description(),
                "processing_options" to _processingOptions(),
            )
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val file: MultipartField<InputStream>,
        private val description: MultipartField<String>,
        private val processingOptions: MultipartField<ProcessingOptions>,
    ) {

        /**
         * The file to upload
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun file(): InputStream = file.value.getRequired("file")

        /**
         * Optional description of the file
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.value.getOptional("description")

        /**
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun processingOptions(): Optional<ProcessingOptions> =
            processingOptions.value.getOptional("processing_options")

        /**
         * Returns the raw multipart value of [file].
         *
         * Unlike [file], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("file") @ExcludeMissing fun _file(): MultipartField<InputStream> = file

        /**
         * Returns the raw multipart value of [description].
         *
         * Unlike [description], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): MultipartField<String> = description

        /**
         * Returns the raw multipart value of [processingOptions].
         *
         * Unlike [processingOptions], this method doesn't throw if the multipart field has an
         * unexpected type.
         */
        @JsonProperty("processing_options")
        @ExcludeMissing
        fun _processingOptions(): MultipartField<ProcessingOptions> = processingOptions

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .file()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var file: MultipartField<InputStream>? = null
            private var description: MultipartField<String> = MultipartField.of(null)
            private var processingOptions: MultipartField<ProcessingOptions> =
                MultipartField.of(null)

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                file = body.file
                description = body.description
                processingOptions = body.processingOptions
            }

            /** The file to upload */
            fun file(file: InputStream) = file(MultipartField.of(file))

            /**
             * Sets [Builder.file] to an arbitrary multipart value.
             *
             * You should usually call [Builder.file] with a well-typed [InputStream] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun file(file: MultipartField<InputStream>) = apply { this.file = file }

            /** The file to upload */
            fun file(file: ByteArray) = file(file.inputStream())

            /** The file to upload */
            fun file(file: Path) =
                file(
                    MultipartField.builder<InputStream>()
                        .value(file.inputStream())
                        .filename(file.name)
                        .build()
                )

            /** Optional description of the file */
            fun description(description: String) = description(MultipartField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary multipart value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: MultipartField<String>) = apply {
                this.description = description
            }

            fun processingOptions(processingOptions: ProcessingOptions) =
                processingOptions(MultipartField.of(processingOptions))

            /**
             * Sets [Builder.processingOptions] to an arbitrary multipart value.
             *
             * You should usually call [Builder.processingOptions] with a well-typed
             * [ProcessingOptions] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun processingOptions(processingOptions: MultipartField<ProcessingOptions>) = apply {
                this.processingOptions = processingOptions
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .file()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body = Body(checkRequired("file", file), description, processingOptions)
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            file()
            description()
            processingOptions().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: AcmeAiSdkInvalidDataException) {
                false
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && file == other.file && description == other.description && processingOptions == other.processingOptions /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, description, processingOptions) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{file=$file, description=$description, processingOptions=$processingOptions}"
    }

    class ProcessingOptions
    private constructor(
        private val language: MultipartField<String>,
        private val ocr: MultipartField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * Preferred language for processing
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.value.getOptional("language")

        /**
         * Enable OCR for image-based documents
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun ocr(): Optional<Boolean> = ocr.value.getOptional("ocr")

        /**
         * Returns the raw multipart value of [language].
         *
         * Unlike [language], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): MultipartField<String> = language

        /**
         * Returns the raw multipart value of [ocr].
         *
         * Unlike [ocr], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("ocr") @ExcludeMissing fun _ocr(): MultipartField<Boolean> = ocr

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

            /** Returns a mutable builder for constructing an instance of [ProcessingOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ProcessingOptions]. */
        class Builder internal constructor() {

            private var language: MultipartField<String> = MultipartField.of(null)
            private var ocr: MultipartField<Boolean> = MultipartField.of(null)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(processingOptions: ProcessingOptions) = apply {
                language = processingOptions.language
                ocr = processingOptions.ocr
                additionalProperties = processingOptions.additionalProperties.toMutableMap()
            }

            /** Preferred language for processing */
            fun language(language: String) = language(MultipartField.of(language))

            /**
             * Sets [Builder.language] to an arbitrary multipart value.
             *
             * You should usually call [Builder.language] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun language(language: MultipartField<String>) = apply { this.language = language }

            /** Enable OCR for image-based documents */
            fun ocr(ocr: Boolean) = ocr(MultipartField.of(ocr))

            /**
             * Sets [Builder.ocr] to an arbitrary multipart value.
             *
             * You should usually call [Builder.ocr] with a well-typed [Boolean] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ocr(ocr: MultipartField<Boolean>) = apply { this.ocr = ocr }

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

        return /* spotless:off */ other is FileFileCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "FileFileCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
