plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
}

dependencies {
    api(project(":core:core_storage"))
    api(project(":core:core_presentation"))
    api(project(":libraries:database_api"))
    api(project(":libraries:crypto_api"))

    // common
    api(CoreDependency.KOTLIN)
    api(CoreDependency.COROUTINES_CORE)
    api(CoreDependency.COROUTINES_ANDROID)
    api(CoreDependency.DAGGER)
    api(CoreDependency.JODA)
    api(CoreDependency.TIMBER)
}
