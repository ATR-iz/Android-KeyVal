plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    id(GradlePluginId.SAFE_ARGS)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    implementation(project(":core:core"))

    implementation(CoreDependency.TIMBER_LOGGER)
    implementation(StorageDependency.CRYPTO)

    kapt(CoreDependency.DAGGER_COMPILER)
}