object GradlePluginVersions {
    const val KOTLIN = CoreVersions.KOTLIN
    const val ANDROID_GRADLE = "4.1.1"
    const val SAFE_ARGS = "2.3.3"
    const val DETEKT = "1.16.0-RC2"
}

object GradlePluginId {
    const val ANDROID_COMMON_CONFIG = "common-android-config"
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KAPT = "kapt"
    const val SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val PARCELIZE = "kotlin-parcelize"
}

object GradlePluginDependency {
    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${GradlePluginVersions.DETEKT}"
    const val ANDROID_BUILD_TOOLS = "com.android.tools.build:gradle:${GradlePluginVersions.ANDROID_GRADLE}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${CoreVersions.KOTLIN}"
    const val DETEKT_FORMATTING = "io.gitlab.arturbosch.detekt:detekt-formatting:${GradlePluginVersions.DETEKT}"
    const val SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${GradlePluginVersions.SAFE_ARGS}"
}
