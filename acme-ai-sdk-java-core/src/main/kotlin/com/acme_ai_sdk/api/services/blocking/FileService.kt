// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.services.blocking

import com.acme_ai_sdk.api.core.RequestOptions
import com.acme_ai_sdk.api.core.http.HttpResponseFor
import com.acme_ai_sdk.api.models.files.FileFileCreateParams
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse
import com.acme_ai_sdk.api.models.files.FileFileSearchParams
import com.acme_ai_sdk.api.models.files.FileFileSearchResponse
import com.acme_ai_sdk.api.models.files.FileFileslistParams
import com.acme_ai_sdk.api.models.files.FileFileslistResponse
import com.google.errorprone.annotations.MustBeClosed

interface FileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Upload a file for processing with AI. The file will be analyzed and made searchable using
     * natural language queries.
     */
    fun fileCreate(params: FileFileCreateParams): FileFileCreateResponse =
        fileCreate(params, RequestOptions.none())

    /** @see [fileCreate] */
    fun fileCreate(
        params: FileFileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileFileCreateResponse

    /**
     * Search for content within a processed file using natural language queries. Returns relevant
     * passages and their context.
     */
    fun fileSearch(params: FileFileSearchParams): FileFileSearchResponse =
        fileSearch(params, RequestOptions.none())

    /** @see [fileSearch] */
    fun fileSearch(
        params: FileFileSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileFileSearchResponse

    /**
     * Retrieve the processing status of files. Can be filtered by status and sorted by upload time.
     */
    fun fileslist(): FileFileslistResponse = fileslist(FileFileslistParams.none())

    /** @see [fileslist] */
    fun fileslist(
        params: FileFileslistParams = FileFileslistParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FileFileslistResponse

    /** @see [fileslist] */
    fun fileslist(params: FileFileslistParams = FileFileslistParams.none()): FileFileslistResponse =
        fileslist(params, RequestOptions.none())

    /** @see [fileslist] */
    fun fileslist(requestOptions: RequestOptions): FileFileslistResponse =
        fileslist(FileFileslistParams.none(), requestOptions)

    /** A view of [FileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /files/`, but is otherwise the same as
         * [FileService.fileCreate].
         */
        @MustBeClosed
        fun fileCreate(params: FileFileCreateParams): HttpResponseFor<FileFileCreateResponse> =
            fileCreate(params, RequestOptions.none())

        /** @see [fileCreate] */
        @MustBeClosed
        fun fileCreate(
            params: FileFileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileFileCreateResponse>

        /**
         * Returns a raw HTTP response for `get /files/{file_id}/search`, but is otherwise the same
         * as [FileService.fileSearch].
         */
        @MustBeClosed
        fun fileSearch(params: FileFileSearchParams): HttpResponseFor<FileFileSearchResponse> =
            fileSearch(params, RequestOptions.none())

        /** @see [fileSearch] */
        @MustBeClosed
        fun fileSearch(
            params: FileFileSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileFileSearchResponse>

        /**
         * Returns a raw HTTP response for `get /files/`, but is otherwise the same as
         * [FileService.fileslist].
         */
        @MustBeClosed
        fun fileslist(): HttpResponseFor<FileFileslistResponse> =
            fileslist(FileFileslistParams.none())

        /** @see [fileslist] */
        @MustBeClosed
        fun fileslist(
            params: FileFileslistParams = FileFileslistParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FileFileslistResponse>

        /** @see [fileslist] */
        @MustBeClosed
        fun fileslist(
            params: FileFileslistParams = FileFileslistParams.none()
        ): HttpResponseFor<FileFileslistResponse> = fileslist(params, RequestOptions.none())

        /** @see [fileslist] */
        @MustBeClosed
        fun fileslist(requestOptions: RequestOptions): HttpResponseFor<FileFileslistResponse> =
            fileslist(FileFileslistParams.none(), requestOptions)
    }
}
