# Acme AI SDK Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.acme_ai_sdk.api/acme-ai-sdk-java)](https://central.sonatype.com/artifact/com.acme_ai_sdk.api/acme-ai-sdk-java/0.1.0-alpha.2)
[![javadoc](https://javadoc.io/badge2/com.acme_ai_sdk.api/acme-ai-sdk-java/0.1.0-alpha.2/javadoc.svg)](https://javadoc.io/doc/com.acme_ai_sdk.api/acme-ai-sdk-java/0.1.0-alpha.2)

<!-- x-release-please-end -->

The Acme AI SDK Java SDK provides convenient access to the [Acme AI SDK REST API](https://docs.acme-ai-sdk.com) from applications written in Java.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

The REST API documentation can be found on [docs.acme-ai-sdk.com](https://docs.acme-ai-sdk.com). Javadocs are also available on [javadoc.io](https://javadoc.io/doc/com.acme_ai_sdk.api/acme-ai-sdk-java/0.1.0-alpha.2).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.acme_ai_sdk.api:acme-ai-sdk-java:0.1.0-alpha.2")
```

### Maven

```xml
<dependency>
  <groupId>com.acme_ai_sdk.api</groupId>
  <artifactId>acme-ai-sdk-java</artifactId>
  <version>0.1.0-alpha.2</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;

// Configures using the `ACME_AI_SDK_BEARER_TOKEN` environment variable
AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.fromEnv();

FileFileCreateParams params = FileFileCreateParams.builder()
    .file("some content".toByteArray())
    .build();
FileFileCreateResponse response = client.files().fileCreate(params);
```

## Client configuration

Configure the client using environment variables:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;

// Configures using the `ACME_AI_SDK_BEARER_TOKEN` environment variable
AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.fromEnv();
```

Or manually:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;

AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.builder()
    .bearerToken("My Bearer Token")
    .build();
```

Or using a combination of the two approaches:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;

AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.builder()
    // Configures using the `ACME_AI_SDK_BEARER_TOKEN` environment variable
    .fromEnv()
    .bearerToken("My Bearer Token")
    .build();
```

See this table for the available options:

| Setter        | Environment variable       | Required | Default value |
| ------------- | -------------------------- | -------- | ------------- |
| `bearerToken` | `ACME_AI_SDK_BEARER_TOKEN` | true     | -             |

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

## Requests and responses

To send a request to the Acme AI SDK API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.files().fileCreate(...)` should be called with an instance of `FileFileCreateParams`, and it will return an instance of `FileFileCreateResponse`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `ACME_AI_SDK_BEARER_TOKEN` environment variable
AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.fromEnv();

FileFileCreateParams params = FileFileCreateParams.builder()
    .file("some content".toByteArray())
    .build();
CompletableFuture<FileFileCreateResponse> response = client.async().files().fileCreate(params);
```

Or create an asynchronous client from the beginning:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClientAsync;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClientAsync;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `ACME_AI_SDK_BEARER_TOKEN` environment variable
AcmeAiSdkClientAsync client = AcmeAiSdkOkHttpClientAsync.fromEnv();

FileFileCreateParams params = FileFileCreateParams.builder()
    .file("some content".toByteArray())
    .build();
CompletableFuture<FileFileCreateResponse> response = client.files().fileCreate(params);
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## File uploads

The SDK defines methods that accept files.

To upload a file, pass a [`Path`](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html):

```java
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;
import java.nio.file.Paths;

FileFileCreateParams params = FileFileCreateParams.builder()
    .file(Paths.get("/path/to/file"))
    .build();
FileFileCreateResponse response = client.files().fileCreate(params);
```

Or an arbitrary [`InputStream`](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html):

```java
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;
import java.net.URL;

FileFileCreateParams params = FileFileCreateParams.builder()
    .file(new URL("https://example.com//path/to/file").openStream())
    .build();
FileFileCreateResponse response = client.files().fileCreate(params);
```

Or a `byte[]` array:

```java
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;

FileFileCreateParams params = FileFileCreateParams.builder()
    .file("content".getBytes())
    .build();
FileFileCreateResponse response = client.files().fileCreate(params);
```

Note that when passing a non-`Path` its filename is unknown so it will not be included in the request. To manually set a filename, pass a [`MultipartField`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/core/Values.kt):

```java
import com.acme_ai_sdk.api.core.MultipartField;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;
import java.io.InputStream;
import java.net.URL;

FileFileCreateParams params = FileFileCreateParams.builder()
    .file(MultipartField.<InputStream>builder()
        .value(new URL("https://example.com//path/to/file").openStream())
        .filename("/path/to/file")
        .build())
    .build();
FileFileCreateResponse response = client.files().fileCreate(params);
```

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.acme_ai_sdk.api.core.http.Headers;
import com.acme_ai_sdk.api.core.http.HttpResponseFor;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;

FileFileCreateParams params = FileFileCreateParams.builder()
    .file("some content".toByteArray())
    .build();
HttpResponseFor<FileFileCreateResponse> response = client.files().withRawResponse().fileCreate(params);

int statusCode = response.statusCode();
Headers headers = response.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;

FileFileCreateResponse parsedResponse = response.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`AcmeAiSdkServiceException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/AcmeAiSdkServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                            |
  | ------ | ------------------------------------------------------------------------------------------------------------------------------------ |
  | 400    | [`BadRequestException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/UnexpectedStatusCodeException.kt) |

- [`AcmeAiSdkIoException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/AcmeAiSdkIoException.kt): I/O networking errors.

- [`AcmeAiSdkInvalidDataException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/AcmeAiSdkInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`AcmeAiSdkException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/AcmeAiSdkException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `ACME_AI_SDK_LOG` environment variable to `info`:

```sh
$ export ACME_AI_SDK_LOG=info
```

Or to `debug` for more verbose logging:

```sh
$ export ACME_AI_SDK_LOG=debug
```

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a response.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;

AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;

FileFileCreateResponse response = client.files().fileCreate(
  params, RequestOptions.builder().timeout(Duration.ofSeconds(30)).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;
import java.time.Duration;

AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.acme_ai_sdk.api.core.JsonValue;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;

FileFileCreateParams params = FileFileCreateParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set undocumented parameters on _nested_ headers, query params, or body classes, call the `putAdditionalProperty` method on the nested class:

```java
import com.acme_ai_sdk.api.core.JsonValue;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;

FileFileCreateParams params = FileFileCreateParams.builder()
    .processingOptions(FileFileCreateParams.ProcessingOptions.builder()
        .putAdditionalProperty("secretProperty", JsonValue.from("42"))
        .build())
    .build();
```

These properties can be accessed on the nested built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/core/Values.kt) object to its setter:

```java
import com.acme_ai_sdk.api.core.JsonValue;
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;

FileFileCreateParams params = FileFileCreateParams.builder()
    .file(JsonValue.from(42))
    .build();
```

The most straightforward way to create a [`JsonValue`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/core/Values.kt) is using its `from(...)` method:

```java
import com.acme_ai_sdk.api.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.acme_ai_sdk.api.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.files().fileCreate(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.acme_ai_sdk.api.core.JsonField;
import java.io.InputStream;
import java.util.Optional;

JsonField<InputStream> file = client.files().fileCreate(params)._file();

if (file.isMissing()) {
  // The property is absent from the JSON response
} else if (file.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = file.asString();

  // Try to deserialize into a custom type
  MyClass myObject = file.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`AcmeAiSdkInvalidDataException`](acme-ai-sdk-java-core/src/main/kotlin/com/acme_ai_sdk/api/errors/AcmeAiSdkInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;

FileFileCreateResponse response = client.files().fileCreate(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.acme_ai_sdk.api.models.files.FileFileCreateParams;
import com.acme_ai_sdk.api.models.files.FileFileCreateResponse;

FileFileCreateResponse response = client.files().fileCreate(
  params, RequestOptions.builder().responseValidation(true).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.acme_ai_sdk.api.client.AcmeAiSdkClient;
import com.acme_ai_sdk.api.client.okhttp.AcmeAiSdkOkHttpClient;

AcmeAiSdkClient client = AcmeAiSdkOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/ACME-AI-Co/java/issues) with questions, bugs, or suggestions.
