plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:4.1.1")
    implementation("com.android.tools.build:gradle-api:4.1.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.30")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.4.30")
}

gradlePlugin {
    plugins {
        register("common-android-config") {
            id = "common-android-config"
            implementationClass = "com.atriz.common.plugins.CommonAndroidConfigPlugin"
        }
    }
}
