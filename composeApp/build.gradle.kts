import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.pluginGraphql)
    id("dev.icerock.mobile.multiplatform-resources")
    id("kotlin-parcelize")
}

apollo {
    service("service") {
        packageName.set("com.cesarwilly")
    }
}
kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {target->
        target.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            export(libs.moko.resources)
            export(libs.moko.graphics)
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "ComposeApp"
            isStatic = true
            export(libs.decompose)
            export("com.arkivanov.parcelize.darwin:runtime:0.2.3")

        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**']"
    }

    sourceSets {

        androidMain{
            dependsOn(commonMain.get())
            dependencies {

                implementation(libs.compose.ui)
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)
                implementation(libs.koin.androidx.compose)
                implementation(libs.ktor.client.android)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.kotlinx.coroutines.android)
                implementation(libs.android.lottie)
            }
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(compose.animation)
            implementation(compose.animationGraphics)
            implementation(compose.material3)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.decompose)
            implementation(libs.decompose.jetbrains)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.core)
            implementation(libs.koin.test)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.auth)
            implementation(libs.kamel.image)
            implementation(libs.apolloCache)
            implementation(libs.apolloRuntime)
            implementation(libs.date.time)
            implementation(libs.moko.compose)
            implementation(libs.androidx.datastore)
            implementation(libs.essenty.parcelable)
//            api(libs.mvvm.core)
//            api(libs.mvvm.compose)
//            api(libs.lighthousegames.logging)
        }
        iosMain {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
//        val commonTest by getting {
//            dependencies {
//                implementation(kotlin("test"))
//            }
//        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            iosSimulatorArm64Test.dependsOn(this)
//        }

    }

}

android {
    namespace = libs.versions.android.namespace.get()
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = libs.versions.android.id.get()
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes +="META-INF/versions/9/previous-compilation-data.bin"

        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
dependencies {
    implementation(libs.androidx.material3)
}
multiplatformResources {
    multiplatformResourcesPackage = libs.versions.android.namespace.get() // required
    multiplatformResourcesClassName = "SharedRes" // optional, default MR
}