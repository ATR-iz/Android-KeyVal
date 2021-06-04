plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.ANDROID_COMMON_CONFIG)
    id(GradlePluginId.PARCELIZE)
}

dependencies {
    api(PresentationDependency.APPCOMPAT)
    api(PresentationDependency.CONSTRAINT_LAYOUT)
    api(PresentationDependency.MATERIAL_UI)
    api(PresentationDependency.CORE_KTX)

    api(PresentationDependency.LIFECYCLE)
    api(PresentationDependency.LIFECYCLE_RUNTIME_KTX)
    api(PresentationDependency.LIFECYCLE_VIEWMODEL_KTX)
    api(PresentationDependency.LIFECYCLE_LIVEDATA_KTX)

    api(PresentationDependency.NAVIGATION_FRAGMENT)
    api(PresentationDependency.NAVIGATION_FRAGMENT_KTX)
    api(PresentationDependency.NAVIGATION_UI)
    api(PresentationDependency.NAVIGATION_UI_KTX)

    api(PresentationDependency.GROUPIE)
    api(PresentationDependency.GROUPIE_VIEWBINDING)

    api(PresentationDependency.RMR_VIEWBINDING)
}