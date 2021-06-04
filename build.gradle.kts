buildscript {
    val kotlin_version by extra("1.4.31")
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap/")
    }
    dependencies {
        classpath(GradlePluginDependency.ANDROID_BUILD_TOOLS)
        classpath(GradlePluginDependency.KOTLIN)
        classpath(GradlePluginDependency.SAFE_ARGS)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

plugins {
    id(GradlePluginId.DETEKT) version GradlePluginVersions.DETEKT
}

// all projects = root project + sub projects
allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {
    apply(plugin = GradlePluginId.DETEKT)
    detekt {
        config = rootProject.files("detekt/config.yml")
        baseline = rootProject.file("detekt/baseline.xml")
        autoCorrect = true
        parallel = true
        reports {
            html {
                enabled = true
            }
        }
    }
    dependencies {
        detektPlugins(GradlePluginDependency.DETEKT_FORMATTING)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}