package com.atriz.common.plugins

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

val Project.android: BaseExtension?
    get() = extensions.findByName("android") as? BaseExtension

val Project.app: BaseAppModuleExtension?
    get() = extensions.findByName("android") as? BaseAppModuleExtension

val Project.library: LibraryExtension?
    get() = extensions.findByName("android") as? LibraryExtension

val Project.kotlin: KotlinAndroidProjectExtension?
    get() = extensions.findByName("android") as? KotlinAndroidProjectExtension