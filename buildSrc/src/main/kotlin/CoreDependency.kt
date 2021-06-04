internal object CoreVersions {
    const val KOTLIN = "1.4.31"
    const val COROUTINES = "1.4.2"

    const val DAGGER = "2.32"

    const val JODA = "2.10.6"
    const val TIMBER = "4.7.1"
    const val TIMBER_LOGGER = "2.2.0"
}

object CoreDependency {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersions.KOTLIN}"

    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoreVersions.COROUTINES}"
    const val COROUTINES_ANDROID= "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersions.COROUTINES}"

    const val DAGGER = "com.google.dagger:dagger:${CoreVersions.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${CoreVersions.DAGGER}"

    const val JODA = "net.danlew:android.joda:${CoreVersions.JODA}"

    const val TIMBER = "com.jakewharton.timber:timber:${CoreVersions.TIMBER}"
    const val TIMBER_LOGGER = "com.orhanobut:logger:${CoreVersions.TIMBER_LOGGER}"
}