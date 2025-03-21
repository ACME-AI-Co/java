package com.acme_ai_sdk.api.example;

import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileSearchParams;
import com.acme_ai_sdk.api.models.files.FileFileSearchResponse;
import com.acme_ai_sdk.api.models.files.FileFileslistParams;
import com.acme_ai_sdk.api.models.files.FileFileslistResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Example demonstrating the ACME AI SDK for Java
 *
 * This example shows how to:
 * 1. Upload a CSV file for processing
 * 2. Poll for file processing status
 * 3. Search the processed file with a natural language query
 */
public class Main {

    /**
     * Main entry point for the application
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize the SDK client with bearer token from environment variable
        AcmeAiSdkClient client = createClient();

        try {
            // Upload a file
            String fileId = uploadFile(client);
            System.out.println("File uploaded with ID: " + fileId);

            // Poll for file processing completion
            waitForFileProcessing(client, fileId);
            System.out.println("File processing completed");

            // Search the file
            searchFile(client, fileId);
        } finally {
            // Close the client to release resources
            client.close();
        }
    }

    /**
     * Creates and configures the ACME AI SDK client
     */
    private static AcmeAiSdkClient createClient() {
        // Get bearer token from environment variable
        String bearerToken = System.getenv("ACME_AI_SDK_BEARER_TOKEN");
        if (bearerToken == null || bearerToken.isEmpty()) {
            throw new IllegalStateException("ACME_AI_SDK_BEARER_TOKEN environment variable is required");
        }

        // Build client using the OkHttp-based client builder
        return AcmeAiSdkOkHttpClient.builder().bearerToken(bearerToken).build();
    }

    /**
     * Uploads a CSV file for processing
     *
     * @param client The SDK client
     * @return The ID of the uploaded file
     */
    private static String uploadFile(AcmeAiSdkClient client) {
        // Get file path
        Path filePath = Paths.get("src/main/resources/birds.csv").toAbsolutePath();
        System.out.println("Uploading file from: " + filePath.toString());

        // Create file upload parameters
        FileFileCreateParams params = FileFileCreateParams.builder()
                .file(filePath)
                .description("Bird species information")
                .build();

        // Upload the file
        return client.files()
                .fileCreate(params)
                .fileId()
                .orElseThrow(() -> new RuntimeException("Failed to get file ID from response"));
    }

    /**
     * Polls for file processing status until completed
     *
     * @param client The SDK client
     * @param fileId The ID of the file to check
     */
    private static void waitForFileProcessing(AcmeAiSdkClient client, String fileId) throws RuntimeException {
        // Create polling parameters
        FileFileslistParams params = FileFileslistParams.builder().build();

        // Poll until file status is "completed"
        boolean isProcessingComplete = false;
        while (!isProcessingComplete) {
            try {
                // Get file list
                FileFileslistResponse response = client.files().fileslist(params);

                // Find our file in the list and check its status
                Optional<String> status = Optional.empty();
                if (response.files().isPresent()) {
                    status = response.files().get().stream()
                            .filter(file -> file.fileId().isPresent())
                            .filter(file -> fileId.equals(file.fileId().get()))
                            .flatMap(file -> file.status().isPresent()
                                    ? Stream.of(file.status().get().asString())
                                    : Stream.empty())
                            .findFirst();
                }

                if (status.isPresent() && "completed".equals(status.get())) {
                    isProcessingComplete = true;
                } else {
                    System.out.println("File status: " + status.orElse("unknown") + ", waiting...");
                    // Sleep for 1 second before checking again
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Polling for file processing was interrupted", e);
            }
        }
    }

    /**
     * Searches the processed file with a natural language query
     *
     * @param client The SDK client
     * @param fileId The ID of the file to search
     */
    private static void searchFile(AcmeAiSdkClient client, String fileId) {
        // Create search parameters
        FileFileSearchParams params = FileFileSearchParams.builder()
                .fileId(fileId)
                .query("chickadee")
                .contextSize(100L) // Include 100 characters before and after matches
                .maxResults(5L) // Limit to 5 results
                .build();

        // Search the file
        FileFileSearchResponse response = client.files().fileSearch(params);

        // Print search results
        System.out.println("\nSearch results for 'chickadee':");
        if (response.results().isPresent()) {
            response.results().get().forEach(result -> {
                System.out.println("Match: " + result.passage().orElse(""));
                if (result.pageNumber().isPresent()) {
                    System.out.println("Page: " + result.pageNumber().get());
                }
                if (result.relevanceScore().isPresent()) {
                    System.out.println("Score: " + result.relevanceScore().get());
                }
                System.out.println("---");
            });
        } else {
            System.out.println("No results found");
        }
    }
}
