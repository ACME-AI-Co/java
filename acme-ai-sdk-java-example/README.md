# ACME AI SDK Java Example

This example demonstrates how to use the ACME AI SDK for Java to:

1. Upload a file for processing
2. Poll for file processing completion
3. Search the processed file with natural language queries

## Prerequisites

- Java 8 or higher
- Gradle
- ACME AI API key (set as environment variable)

## Setup

1. Set your API key as an environment variable:
   ```bash
   export ACME_AI_SDK_BEARER_TOKEN="your_api_key_here"
   ```

2. Build the project:
   ```bash
   ./gradlew build
   ```

## Running the Example

```bash
./gradlew :acme-ai-sdk-java-example:run
```

## What This Example Does

1. **Initialize the Client**: Creates an ACME AI SDK client with your API key
2. **Upload a File**: Uploads a CSV file of bird species from `src/main/resources/birds.csv`
3. **Poll for Completion**: Checks the file processing status until completed
4. **Search the File**: Searches for information about "chickadee" in the processed file

## Code Structure

- `Main.java`: Main application entry point
- `birds.csv`: Sample data file for upload and search

## Further Reading

For more information, please refer to the [ACME AI SDK documentation](https://docs.acme-ai.com).