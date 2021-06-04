plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    implementation(StorageDependency.ROOM)
    kapt(StorageDependency.ROOM_COMPILER)
    implementation(StorageDependency.ROOM_EXTENSIONS)
}