plugins {
    id("acme-ai-sdk.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":acme-ai-sdk-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass.set("com.acme_ai_sdk.api.example.Main")
}
