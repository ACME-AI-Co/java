# Changelog

## 0.1.0-alpha.3 (2025-04-10)

Full Changelog: [v0.1.0-alpha.2...v0.1.0-alpha.3](https://github.com/ACME-AI-Co/java/compare/v0.1.0-alpha.2...v0.1.0-alpha.3)

### Features

* **client:** add enum validation method ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **client:** expose request body setter and getter ([#14](https://github.com/ACME-AI-Co/java/issues/14)) ([cbc3fab](https://github.com/ACME-AI-Co/java/commit/cbc3fabefa800049333cd088ea89b0c4fa456968))
* **client:** make datetime deserialization more lenient ([#13](https://github.com/ACME-AI-Co/java/issues/13)) ([f42604b](https://github.com/ACME-AI-Co/java/commit/f42604bc2ef2b86a9fcf0cc7a4a5e0b8c172887f))
* **client:** make union deserialization more robust ([#12](https://github.com/ACME-AI-Co/java/issues/12)) ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **client:** support setting base URL via env var ([90cd868](https://github.com/ACME-AI-Co/java/commit/90cd868b7ba7d0aa6f5b0b45021bbaf63d3f3561))


### Bug Fixes

* **client:** bump to better jackson version ([9c2074f](https://github.com/ACME-AI-Co/java/commit/9c2074f973ae1a4dac9e5d626c52028eaaa1e152))
* **client:** don't call `validate()` during deserialization if we don't have to ([#9](https://github.com/ACME-AI-Co/java/issues/9)) ([70b686e](https://github.com/ACME-AI-Co/java/commit/70b686ee76a3d6d48e8cac857ce562b9c99d44fc))
* **client:** limit json deserialization coercion ([#11](https://github.com/ACME-AI-Co/java/issues/11)) ([08b75d0](https://github.com/ACME-AI-Co/java/commit/08b75d012051d5a62bc324723230d4010cbe3825))
* **client:** return `Optional&lt;T&gt;` instead of `Optional<? extends T>` ([#17](https://github.com/ACME-AI-Co/java/issues/17)) ([00d839a](https://github.com/ACME-AI-Co/java/commit/00d839a9fdf45ee049610bcfcba2703883b6eec2))


### Performance Improvements

* **client:** cached parsed type in `HttpResponseFor` ([#15](https://github.com/ACME-AI-Co/java/issues/15)) ([1d730ba](https://github.com/ACME-AI-Co/java/commit/1d730ba55127f588c615ab265bd76f5e50e57762))


### Chores

* **client:** remove unnecessary json state from some query param classes ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **internal:** add invalid json deserialization tests ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **internal:** add json roundtripping tests ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **internal:** expand CI branch coverage ([e8353a2](https://github.com/ACME-AI-Co/java/commit/e8353a2850316049584ebc86ae879d86da77e44f))
* **internal:** reduce CI branch coverage ([177220a](https://github.com/ACME-AI-Co/java/commit/177220ac4d7a3fa455081fd43483a411325a4e9d))
* **internal:** swap from `getNullable` to `getOptional` ([#16](https://github.com/ACME-AI-Co/java/issues/16)) ([98af3ec](https://github.com/ACME-AI-Co/java/commit/98af3ecbf83f40a293dd1578e0f60faa30280d53))
* **internal:** update file param examples ([619ebfb](https://github.com/ACME-AI-Co/java/commit/619ebfb73b3b696c3497b454e49a4da85ef4aec6))


### Documentation

* add comments to `JsonField` classes ([00d839a](https://github.com/ACME-AI-Co/java/commit/00d839a9fdf45ee049610bcfcba2703883b6eec2))
* document how to forcibly omit required field ([fd14281](https://github.com/ACME-AI-Co/java/commit/fd14281955c7ba3b738c3783a2dc8890fc1db862))
* swap examples used in readme ([#18](https://github.com/ACME-AI-Co/java/issues/18)) ([fd14281](https://github.com/ACME-AI-Co/java/commit/fd14281955c7ba3b738c3783a2dc8890fc1db862))

## 0.1.0-alpha.2 (2025-03-26)

Full Changelog: [v0.1.0-alpha.1...v0.1.0-alpha.2](https://github.com/ACME-AI-Co/java/compare/v0.1.0-alpha.1...v0.1.0-alpha.2)

### Features

* **client:** support a lower jackson version ([#7](https://github.com/ACME-AI-Co/java/issues/7)) ([0633a68](https://github.com/ACME-AI-Co/java/commit/0633a68d825e0ecd784538e5fe5ca98743bf0c7e))
* **client:** throw on incompatible jackson version ([0633a68](https://github.com/ACME-AI-Co/java/commit/0633a68d825e0ecd784538e5fe5ca98743bf0c7e))
* **docs:** example work ([f26e34e](https://github.com/ACME-AI-Co/java/commit/f26e34edbb3829a00684f227a94b781b978fad63))


### Documentation

* minor readme tweak ([#6](https://github.com/ACME-AI-Co/java/issues/6)) ([e267ad2](https://github.com/ACME-AI-Co/java/commit/e267ad2985be41cdae0df71bc8b696cd08d77620))
* update readme exception docs ([#4](https://github.com/ACME-AI-Co/java/issues/4)) ([6f308de](https://github.com/ACME-AI-Co/java/commit/6f308de5475776af387e7936f865d2d929ce13ff))

## 0.1.0-alpha.1 (2025-03-21)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/ACME-AI-Co/java/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### Features

* **api:** update via SDK Studio ([#1](https://github.com/ACME-AI-Co/java/issues/1)) ([f579370](https://github.com/ACME-AI-Co/java/commit/f579370db67d9466b960fce6fbcb2fed1f57c5b2))
* **docs:** add example script ([fa178f4](https://github.com/ACME-AI-Co/java/commit/fa178f43e34d61418552f1d76ac73bd84d60b4ab))


### Chores

* configure new SDK language ([9d4fda2](https://github.com/ACME-AI-Co/java/commit/9d4fda26bb046f9a015aee10ed5d0a2daac05d0f))
