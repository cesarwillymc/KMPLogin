plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.pluginGraphql).apply(false)
}

allprojects {
    configurations {
        all {
            resolutionStrategy {
//                force("org.jetbrains.kotlinx:kotlinx-coroutines-core:x.y.z-native-mt")

            }
        }
    }
}