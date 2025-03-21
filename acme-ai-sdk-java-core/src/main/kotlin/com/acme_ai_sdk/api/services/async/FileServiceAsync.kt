// File generated from our OpenAPI spec by Stainless.

package com.acme_ai_sdk.api.services.async

import com.acme_ai_sdk.api.core.RequestOptions
import com.acme_ai_sdk.api.core.http.HttpResponseFor
import com.acme_ai_sdk.api.models.files.FileFileCreateParams
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse
import com.acme_ai_sdk.api.models.files.FileFileSearchParams
import com.acme_ai_sdk.api.models.files.FileFileSearchResponse
import com.acme_ai_sdk.api.models.files.FileFileslistParams
import com.acme_ai_sdk.api.models.files.FileFileslistResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.concurrent.CompletableFuture

interface FileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Upload a file for processing with AI. The file will be analyzed and made searchable using
     * natural language queries.
     */
    fun fileCreate(params: FileFileCreateParams): CompletableFuture<FileFileCreateResponse> =
        fileCreate(params, RequestOptions.none())

    /** @see [fileCreate] */
    fun fileCreate(
        params: FileFileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileFileCreateResponse>

    /**
     * Search for content within a processed file using natural language queries. Returns relevant
     * passages and their context.
     */
    fun fileSearch(params: FileFileSearchParams): CompletableFuture<FileFileSearchResponse> =
        fileSearch(params, RequestOptions.none())

    /** @see [fileSearch] */
    fun fileSearch(
        params: FileFileSearchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileFileSearchResponse>

    /**
     * Retrieve the processing status of files. Can be filtered by status and sorted by upload time.
     */
    fun fileslist(): CompletableFuture<FileFileslistResponse> =
        fileslist(FileFileslistParams.none())

    /** @see [fileslist] */
    fun fileslist(
        params: FileFileslistParams = FileFileslistParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileFileslistResponse>

    /** @see [fileslist] */
    fun fileslist(
        params: FileFileslistParams = FileFileslistParams.none()
    ): CompletableFuture<FileFileslistResponse> = fileslist(params, RequestOptions.none())

    /** @see [fileslist] */
    fun fileslist(requestOptions: RequestOptions): CompletableFuture<FileFileslistResponse> =
        fileslist(FileFileslistParams.none(), requestOptions)

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /files/`, but is otherwise the same as
         * [FileServiceAsync.fileCreate].
         */
        @MustBeClosed
        fun fileCreate(
            params: FileFileCreateParams
        ): CompletableFuture<HttpResponseFor<FileFileCreateResponse>> =
            fileCreate(params, RequestOptions.none())

        /** @see [fileCreate] */
        @MustBeClosed
        fun fileCreate(
            params: FileFileCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileFileCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /files/{file_id}/search`, but is otherwise the same
         * as [FileServiceAsync.fileSearch].
         */
        @MustBeClosed
        fun fileSearch(
            params: FileFileSearchParams
        ): CompletableFuture<HttpResponseFor<FileFileSearchResponse>> =
            fileSearch(params, RequestOptions.none())

        /** @see [fileSearch] */
        @MustBeClosed
        fun fileSearch(
            params: FileFileSearchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileFileSearchResponse>>

        /**
         * Returns a raw HTTP response for `get /files/`, but is otherwise the same as
         * [FileServiceAsync.fileslist].
         */
        @MustBeClosed
        fun fileslist(): CompletableFuture<HttpResponseFor<FileFileslistResponse>> =
            fileslist(FileFileslistParams.none())

        /** @see [fileslist] */
        @MustBeClosed
        fun fileslist(
            params: FileFileslistParams = FileFileslistParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileFileslistResponse>>

        /** @see [fileslist] */
        @MustBeClosed
        fun fileslist(
            params: FileFileslistParams = FileFileslistParams.none()
        ): CompletableFuture<HttpResponseFor<FileFileslistResponse>> =
            fileslist(params, RequestOptions.none())

        /** @see [fileslist] */
        @MustBeClosed
        fun fileslist(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FileFileslistResponse>> =
            fileslist(FileFileslistParams.none(), requestOptions)
    }
}
