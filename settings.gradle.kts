enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
}

rootProject.name = "KMPLogin"
include(":shared")