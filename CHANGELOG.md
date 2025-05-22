# Changelog

## 0.1.0-alpha.3 (2025-05-22)

Full Changelog: [v0.1.0-alpha.2...v0.1.0-alpha.3](https://github.com/ACME-AI-Co/java/compare/v0.1.0-alpha.2...v0.1.0-alpha.3)

### ⚠ BREAKING CHANGES

* **client:** change precision of some numeric types
* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - `AutoPagerAsync` now has different usage. You can call `.subscribe(...)` on the returned object instead to get called back each page item. You can also call `onCompleteFuture()` to get a future that completes when all items have been processed. Finally, you can call `.close()` on the returned object to stop auto-paginating early
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-optional types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)

### Features

* **client:** add enum validation method ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **client:** allow providing some params positionally ([a2c1a33](https://github.com/ACME-AI-Co/java/commit/a2c1a33040e90beede2ca29b4923a8d64c38c1cc))
* **client:** expose request body setter and getter ([#14](https://github.com/ACME-AI-Co/java/issues/14)) ([cbc3fab](https://github.com/ACME-AI-Co/java/commit/cbc3fabefa800049333cd088ea89b0c4fa456968))
* **client:** extract auto pagination to shared classes ([8e47161](https://github.com/ACME-AI-Co/java/commit/8e4716128ec00dc3aedfbfa01d20f43741a6427a))
* **client:** make datetime deserialization more lenient ([#13](https://github.com/ACME-AI-Co/java/issues/13)) ([f42604b](https://github.com/ACME-AI-Co/java/commit/f42604bc2ef2b86a9fcf0cc7a4a5e0b8c172887f))
* **client:** make union deserialization more robust ([#12](https://github.com/ACME-AI-Co/java/issues/12)) ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **client:** support setting base URL via env var ([90cd868](https://github.com/ACME-AI-Co/java/commit/90cd868b7ba7d0aa6f5b0b45021bbaf63d3f3561))


### Bug Fixes

* **client:** add missing convenience methods ([1a01db6](https://github.com/ACME-AI-Co/java/commit/1a01db6ab97a95612c7a555f777df732c1976e6f))
* **client:** bump to better jackson version ([9c2074f](https://github.com/ACME-AI-Co/java/commit/9c2074f973ae1a4dac9e5d626c52028eaaa1e152))
* **client:** don't call `validate()` during deserialization if we don't have to ([#9](https://github.com/ACME-AI-Co/java/issues/9)) ([70b686e](https://github.com/ACME-AI-Co/java/commit/70b686ee76a3d6d48e8cac857ce562b9c99d44fc))
* **client:** limit json deserialization coercion ([#11](https://github.com/ACME-AI-Co/java/issues/11)) ([08b75d0](https://github.com/ACME-AI-Co/java/commit/08b75d012051d5a62bc324723230d4010cbe3825))
* **client:** return `Optional&lt;T&gt;` instead of `Optional<? extends T>` ([#17](https://github.com/ACME-AI-Co/java/issues/17)) ([00d839a](https://github.com/ACME-AI-Co/java/commit/00d839a9fdf45ee049610bcfcba2703883b6eec2))


### Performance Improvements

* **client:** cached parsed type in `HttpResponseFor` ([#15](https://github.com/ACME-AI-Co/java/issues/15)) ([1d730ba](https://github.com/ACME-AI-Co/java/commit/1d730ba55127f588c615ab265bd76f5e50e57762))
* **internal:** improve compilation+test speed ([6448952](https://github.com/ACME-AI-Co/java/commit/6448952577749ed59def72dddc7da7a35fa3da99))


### Chores

* **ci:** add timeout thresholds for CI jobs ([4b14840](https://github.com/ACME-AI-Co/java/commit/4b1484057589efe2040cd293ed82896b20c3eae0))
* **ci:** only use depot for staging repos ([8a46831](https://github.com/ACME-AI-Co/java/commit/8a46831c4497a75dee363834fc235995114034bc))
* **client:** remove unnecessary json state from some query param classes ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **docs:** grammar improvements ([4c295eb](https://github.com/ACME-AI-Co/java/commit/4c295ebb0515f2c403f6ca0fa2034ff984456a88))
* **internal:** add invalid json deserialization tests ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **internal:** add json roundtripping tests ([e0c8fc1](https://github.com/ACME-AI-Co/java/commit/e0c8fc17937269066e0fe8c906d70c8cb5f07df0))
* **internal:** codegen related update ([d96d458](https://github.com/ACME-AI-Co/java/commit/d96d458540864f6029dca3da407c6b7302e6b09b))
* **internal:** expand CI branch coverage ([e8353a2](https://github.com/ACME-AI-Co/java/commit/e8353a2850316049584ebc86ae879d86da77e44f))
* **internal:** java 17 -&gt; 21 on ci ([da14d21](https://github.com/ACME-AI-Co/java/commit/da14d2177d4a7acccbb613385bfdcbfcad04cf09))
* **internal:** reduce CI branch coverage ([177220a](https://github.com/ACME-AI-Co/java/commit/177220ac4d7a3fa455081fd43483a411325a4e9d))
* **internal:** remove flaky `-Xbackend-threads=0` option ([567e8ff](https://github.com/ACME-AI-Co/java/commit/567e8ffd5881f3f02e11a580bf26d9eeafd4fa50))
* **internal:** swap from `getNullable` to `getOptional` ([#16](https://github.com/ACME-AI-Co/java/issues/16)) ([98af3ec](https://github.com/ACME-AI-Co/java/commit/98af3ecbf83f40a293dd1578e0f60faa30280d53))
* **internal:** update file param examples ([619ebfb](https://github.com/ACME-AI-Co/java/commit/619ebfb73b3b696c3497b454e49a4da85ef4aec6))
* **internal:** update java toolchain ([42e4459](https://github.com/ACME-AI-Co/java/commit/42e44590d4fcd2400487f4f3fb9bc95afd790dcd))
* **internal:** use `byteInputStream()` in tests ([1a01db6](https://github.com/ACME-AI-Co/java/commit/1a01db6ab97a95612c7a555f777df732c1976e6f))


### Documentation

* add comments to `JsonField` classes ([00d839a](https://github.com/ACME-AI-Co/java/commit/00d839a9fdf45ee049610bcfcba2703883b6eec2))
* **client:** update jackson compat error message ([e41827b](https://github.com/ACME-AI-Co/java/commit/e41827b95b80329ffd5fa74d9395affe4bf6c640))
* document how to forcibly omit required field ([fd14281](https://github.com/ACME-AI-Co/java/commit/fd14281955c7ba3b738c3783a2dc8890fc1db862))
* explain http client customization ([c448c2a](https://github.com/ACME-AI-Co/java/commit/c448c2ac8036f8c07d187baf56136d447966902e))
* explain jackson compat in readme ([b98a664](https://github.com/ACME-AI-Co/java/commit/b98a664ce7b85420531a055bf10cc9ca255bc8be))
* swap examples used in readme ([#18](https://github.com/ACME-AI-Co/java/issues/18)) ([fd14281](https://github.com/ACME-AI-Co/java/commit/fd14281955c7ba3b738c3783a2dc8890fc1db862))
* update documentation links to be more uniform ([e4998de](https://github.com/ACME-AI-Co/java/commit/e4998defeef7a03baab9b874e2212f32cb62e329))


### Refactors

* **client:** change precision of some numeric types ([29601e6](https://github.com/ACME-AI-Co/java/commit/29601e68f7ddfa8edc91152ac9b39e385f23e4e4))

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
