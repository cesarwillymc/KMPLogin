-dontwarn android.test.**
-dontwarn org.junit.**
-dontwarn com.google.common.**
##---------------Begin: proguard configuration for Ktor  ----------
-keep class io.ktor.** { *; }
-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.atomicfu.**
-dontwarn io.netty.**
-dontwarn com.typesafe.**
-dontwarn org.slf4j.**
-keep class io.netty.** {*; }
-keep class kotlin.reflect.jvm.internal.** { *; }

-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations




-dontwarn androidx.lifecycle.LiveData
# Koin
-verbose
-dontwarn java.lang.management.ManagementFactory
-dontwarn java.lang.management.RuntimeMXBean

-keepclassmembers class * { public <init>(...); }

-keep class kotlin.Metadata { *; }
-keep class kotlin.reflect.** { *; }

-keep class org.koin.** { *; }
-keep class org.koin.core.** { *; }
-keep class org.koin.dsl.** { *; }
-dontwarn org.koin.**


-keep class com.cesarwillymc.kmplogin.data.auth.entities.** { *; }
-keep class com.cesarwillymc.kmplogin.domain.usecase.auth.entities.** { *; }
-keep class com.cesarwillymc.kmplogin.domain.usecase.survey.entities.** { *; }
-keep class com.cesarwillymc.kmplogin.presentation.validations.common.** { *; }
-keep class com.cesarwillymc.kmplogin.presentation.utils.** { *; }
-keep class com.cesarwillymc.kmplogin.di.** { *; }
-keep class com.cesarwillymc.kmplogin.framework.** { *; }
-keep class com.cesarwillymc.kmplogin.presentation.utils.SecretsProvider.** { *; }
-keep class com.cesarwillymc.kmplogin.presentation.utils.SecretsProvider_androidKt.** { *; }
-keepdirectories res/raw/local.properties
