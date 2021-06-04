package com.atriz.common.plugins

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonAndroidConfigPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyAndroidConfig()
            applyKotlinConfig()
        }
    }

    private fun Project.applyPlugins() {
        plugins.run {
            apply("kotlin-android")
        }
    }

    private fun Project.applyAndroidConfig() {
        android?.run {
            defaultConfig {
                minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
                targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
                compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            sourceSets.forEach { it.java.srcDir("src/${it.name}/kotlin") }
        }
        app?.run {
            defaultConfig {
                applicationId = "com.atriz.keyval"
            }

            buildTypes {
                val proguardFiles = rootProject.fileTree("proguard").files +
                        getDefaultProguardFile("proguard-android-optimize.txt")

                getByName(BuildType.DEBUG) {
                    buildConfigField("Boolean", "ENABLE_LOGS", "true")
                }

                getByName(BuildType.RELEASE) {
                    buildConfigField("Boolean", "ENABLE_LOGS", "false")
                    isDebuggable = false
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles("proguard-rules.pro", *proguardFiles.toTypedArray())
                }
            }

            buildFeatures {
                viewBinding = true
            }
        }
        library?.run {
            buildTypes {
                val proguardFiles = rootProject.fileTree("proguard").files +
                        getDefaultProguardFile("proguard-android-optimize.txt")

                getByName(BuildType.DEBUG) {
                    buildConfigField("Boolean", "ENABLE_LOGS", "true")
                }

                getByName(BuildType.RELEASE) {
                    buildConfigField("Boolean", "ENABLE_LOGS", "false")
                    isDebuggable = false
                    isMinifyEnabled = true
                    proguardFiles("proguard-rules.pro", *proguardFiles.toTypedArray())
                }
            }

            buildFeatures {
                viewBinding = true
            }
        }
    }

    private fun Project.applyKotlinConfig() {
        this.tasks.withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }
}