private object PresentationsVersions {
    // UI
    const val CORE_KTX = "1.5.0-rc01"
    const val APPCOMPAT = "1.2.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val MATERIAL_UI = "1.3.0"

    const val NAVIGATION = "2.3.3"
    const val GROUPIE = "2.9.0"

    const val LIFECYCLE = "2.2.0"

    const val RMR_VIEWBINDING = "4.1.2-2"
}

object PresentationDependency {
    // CORE
    const val APPCOMPAT = "androidx.appcompat:appcompat:${PresentationsVersions.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${PresentationsVersions.CONSTRAINT_LAYOUT}"
    const val MATERIAL_UI = "com.google.android.material:material:${PresentationsVersions.MATERIAL_UI}"
    const val CORE_KTX = "androidx.core:core-ktx:${PresentationsVersions.CORE_KTX}"

    // NAVIGATION
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment:${PresentationsVersions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui:${PresentationsVersions.NAVIGATION}"
    const val NAVIGATION_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${PresentationsVersions.NAVIGATION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${PresentationsVersions.NAVIGATION}"

    // GROUPIE
    const val GROUPIE = "com.xwray:groupie:${PresentationsVersions.GROUPIE}"
    const val GROUPIE_VIEWBINDING = "com.xwray:groupie-viewbinding:${PresentationsVersions.GROUPIE}"

    //LIFECYCLE
    const val LIFECYCLE = "androidx.lifecycle:lifecycle-extensions:${PresentationsVersions.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${PresentationsVersions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${PresentationsVersions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${PresentationsVersions.LIFECYCLE}"

    //REDMADROBOT ViewBinding
    const val RMR_VIEWBINDING = "com.redmadrobot.extensions:viewbinding-ktx:${PresentationsVersions.RMR_VIEWBINDING}"
}
