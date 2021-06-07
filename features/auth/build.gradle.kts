plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    id(GradlePluginId.SAFE_ARGS)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    implementation(project(":core:core"))

    kapt(CoreDependency.DAGGER_COMPILER)
}
