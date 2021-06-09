plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    id(GradlePluginId.SAFE_ARGS)
    kotlin(GradlePluginId.KAPT)
}

dependencies {
    implementation(project(":core:core"))
    implementation(project(":features:auth"))
    implementation(project(":features:home:create_account"))
    implementation(project(":features:home:create_group"))
    implementation(project(":features:home:group"))
    implementation(project(":features:home:home"))
    implementation(project(":features:home:password"))

    implementation(CoreDependency.TIMBER_LOGGER)
    implementation(StorageDependency.CRYPTO)

    kapt(CoreDependency.DAGGER_COMPILER)
}