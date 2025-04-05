// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.models.files

import com.acme_ai_sdk.api.core.Enum
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

class FileFileslistResponse
private constructor(
    private val files: JsonField<List<File>>,
    private val limit: JsonField<Long>,
    private val offset: JsonField<Long>,
    private val total: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("files") @ExcludeMissing files: JsonField<List<File>> = JsonMissing.of(),
        @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("offset") @ExcludeMissing offset: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
    ) : this(files, limit, offset, total, mutableMapOf())

    /**
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun files(): Optional<List<File>> = files.getOptional("files")

    /**
     * Maximum number of files returned
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limit(): Optional<Long> = limit.getOptional("limit")

    /**
     * Number of files skipped
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun offset(): Optional<Long> = offset.getOptional("offset")

    /**
     * Total number of files matching the filter
     *
     * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun total(): Optional<Long> = total.getOptional("total")

    /**
     * Returns the raw JSON value of [files].
     *
     * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("files") @ExcludeMissing fun _files(): JsonField<List<File>> = files

    /**
     * Returns the raw JSON value of [limit].
     *
     * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

    /**
     * Returns the raw JSON value of [offset].
     *
     * Unlike [offset], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("offset") @ExcludeMissing fun _offset(): JsonField<Long> = offset

    /**
     * Returns the raw JSON value of [total].
     *
     * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

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

        /** Returns a mutable builder for constructing an instance of [FileFileslistResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileFileslistResponse]. */
    class Builder internal constructor() {

        private var files: JsonField<MutableList<File>>? = null
        private var limit: JsonField<Long> = JsonMissing.of()
        private var offset: JsonField<Long> = JsonMissing.of()
        private var total: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileFileslistResponse: FileFileslistResponse) = apply {
            files = fileFileslistResponse.files.map { it.toMutableList() }
            limit = fileFileslistResponse.limit
            offset = fileFileslistResponse.offset
            total = fileFileslistResponse.total
            additionalProperties = fileFileslistResponse.additionalProperties.toMutableMap()
        }

        fun files(files: List<File>) = files(JsonField.of(files))

        /**
         * Sets [Builder.files] to an arbitrary JSON value.
         *
         * You should usually call [Builder.files] with a well-typed `List<File>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun files(files: JsonField<List<File>>) = apply {
            this.files = files.map { it.toMutableList() }
        }

        /**
         * Adds a single [File] to [files].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFile(file: File) = apply {
            files =
                (files ?: JsonField.of(mutableListOf())).also { checkKnown("files", it).add(file) }
        }

        /** Maximum number of files returned */
        fun limit(limit: Long) = limit(JsonField.of(limit))

        /**
         * Sets [Builder.limit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

        /** Number of files skipped */
        fun offset(offset: Long) = offset(JsonField.of(offset))

        /**
         * Sets [Builder.offset] to an arbitrary JSON value.
         *
         * You should usually call [Builder.offset] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun offset(offset: JsonField<Long>) = apply { this.offset = offset }

        /** Total number of files matching the filter */
        fun total(total: Long) = total(JsonField.of(total))

        /**
         * Sets [Builder.total] to an arbitrary JSON value.
         *
         * You should usually call [Builder.total] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun total(total: JsonField<Long>) = apply { this.total = total }

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
         * Returns an immutable instance of [FileFileslistResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): FileFileslistResponse =
            FileFileslistResponse(
                (files ?: JsonMissing.of()).map { it.toImmutable() },
                limit,
                offset,
                total,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FileFileslistResponse = apply {
        if (validated) {
            return@apply
        }

        files().ifPresent { it.forEach { it.validate() } }
        limit()
        offset()
        total()
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
        (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (limit.asKnown().isPresent) 1 else 0) +
            (if (offset.asKnown().isPresent) 1 else 0) +
            (if (total.asKnown().isPresent) 1 else 0)

    class File
    private constructor(
        private val completionTime: JsonField<OffsetDateTime>,
        private val error: JsonField<String>,
        private val fileId: JsonField<String>,
        private val fileSize: JsonField<Long>,
        private val filename: JsonField<String>,
        private val status: JsonField<Status>,
        private val uploadTime: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("completion_time")
            @ExcludeMissing
            completionTime: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
            @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("file_size") @ExcludeMissing fileSize: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("filename")
            @ExcludeMissing
            filename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("upload_time")
            @ExcludeMissing
            uploadTime: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            completionTime,
            error,
            fileId,
            fileSize,
            filename,
            status,
            uploadTime,
            mutableMapOf(),
        )

        /**
         * Time processing was completed (if applicable)
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun completionTime(): Optional<OffsetDateTime> =
            completionTime.getOptional("completion_time")

        /**
         * Error message (if status is 'failed')
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun error(): Optional<String> = error.getOptional("error")

        /**
         * Unique identifier for the file
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fileId(): Optional<String> = fileId.getOptional("file_id")

        /**
         * Size of the file in bytes
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fileSize(): Optional<Long> = fileSize.getOptional("file_size")

        /**
         * Original name of the file
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun filename(): Optional<String> = filename.getOptional("filename")

        /**
         * Current processing status
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Time the file was uploaded
         *
         * @throws AcmeAiSdkInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun uploadTime(): Optional<OffsetDateTime> = uploadTime.getOptional("upload_time")

        /**
         * Returns the raw JSON value of [completionTime].
         *
         * Unlike [completionTime], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("completion_time")
        @ExcludeMissing
        fun _completionTime(): JsonField<OffsetDateTime> = completionTime

        /**
         * Returns the raw JSON value of [error].
         *
         * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

        /**
         * Returns the raw JSON value of [fileId].
         *
         * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

        /**
         * Returns the raw JSON value of [fileSize].
         *
         * Unlike [fileSize], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("file_size") @ExcludeMissing fun _fileSize(): JsonField<Long> = fileSize

        /**
         * Returns the raw JSON value of [filename].
         *
         * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [uploadTime].
         *
         * Unlike [uploadTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("upload_time")
        @ExcludeMissing
        fun _uploadTime(): JsonField<OffsetDateTime> = uploadTime

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

            /** Returns a mutable builder for constructing an instance of [File]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [File]. */
        class Builder internal constructor() {

            private var completionTime: JsonField<OffsetDateTime> = JsonMissing.of()
            private var error: JsonField<String> = JsonMissing.of()
            private var fileId: JsonField<String> = JsonMissing.of()
            private var fileSize: JsonField<Long> = JsonMissing.of()
            private var filename: JsonField<String> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var uploadTime: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(file: File) = apply {
                completionTime = file.completionTime
                error = file.error
                fileId = file.fileId
                fileSize = file.fileSize
                filename = file.filename
                status = file.status
                uploadTime = file.uploadTime
                additionalProperties = file.additionalProperties.toMutableMap()
            }

            /** Time processing was completed (if applicable) */
            fun completionTime(completionTime: OffsetDateTime) =
                completionTime(JsonField.of(completionTime))

            /**
             * Sets [Builder.completionTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.completionTime] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun completionTime(completionTime: JsonField<OffsetDateTime>) = apply {
                this.completionTime = completionTime
            }

            /** Error message (if status is 'failed') */
            fun error(error: String) = error(JsonField.of(error))

            /**
             * Sets [Builder.error] to an arbitrary JSON value.
             *
             * You should usually call [Builder.error] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun error(error: JsonField<String>) = apply { this.error = error }

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

            /** Size of the file in bytes */
            fun fileSize(fileSize: Long) = fileSize(JsonField.of(fileSize))

            /**
             * Sets [Builder.fileSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileSize] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileSize(fileSize: JsonField<Long>) = apply { this.fileSize = fileSize }

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

            /** Current processing status */
            fun status(status: Status) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
             * Returns an immutable instance of [File].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): File =
                File(
                    completionTime,
                    error,
                    fileId,
                    fileSize,
                    filename,
                    status,
                    uploadTime,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): File = apply {
            if (validated) {
                return@apply
            }

            completionTime()
            error()
            fileId()
            fileSize()
            filename()
            status().ifPresent { it.validate() }
            uploadTime()
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
            (if (completionTime.asKnown().isPresent) 1 else 0) +
                (if (error.asKnown().isPresent) 1 else 0) +
                (if (fileId.asKnown().isPresent) 1 else 0) +
                (if (fileSize.asKnown().isPresent) 1 else 0) +
                (if (filename.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (uploadTime.asKnown().isPresent) 1 else 0)

        /** Current processing status */
        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val PENDING = of("pending")

                @JvmField val PROCESSING = of("processing")

                @JvmField val COMPLETED = of("completed")

                @JvmField val FAILED = of("failed")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                PENDING,
                PROCESSING,
                COMPLETED,
                FAILED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                PENDING,
                PROCESSING,
                COMPLETED,
                FAILED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    PENDING -> Value.PENDING
                    PROCESSING -> Value.PROCESSING
                    COMPLETED -> Value.COMPLETED
                    FAILED -> Value.FAILED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws AcmeAiSdkInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    PENDING -> Known.PENDING
                    PROCESSING -> Known.PROCESSING
                    COMPLETED -> Known.COMPLETED
                    FAILED -> Known.FAILED
                    else -> throw AcmeAiSdkInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws AcmeAiSdkInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    AcmeAiSdkInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Status = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Status && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is File && completionTime == other.completionTime && error == other.error && fileId == other.fileId && fileSize == other.fileSize && filename == other.filename && status == other.status && uploadTime == other.uploadTime && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(completionTime, error, fileId, fileSize, filename, status, uploadTime, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "File{completionTime=$completionTime, error=$error, fileId=$fileId, fileSize=$fileSize, filename=$filename, status=$status, uploadTime=$uploadTime, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileFileslistResponse && files == other.files && limit == other.limit && offset == other.offset && total == other.total && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(files, limit, offset, total, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileFileslistResponse{files=$files, limit=$limit, offset=$offset, total=$total, additionalProperties=$additionalProperties}"
}
