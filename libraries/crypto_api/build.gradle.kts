plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
    id(GradlePluginId.PARCELIZE)
}

dependencies {
    api(StorageDependency.ROOM)
    kapt(StorageDependency.ROOM_COMPILER)
    implementation(StorageDependency.ROOM_EXTENSIONS)
    implementation(project(":core:core_storage"))
}