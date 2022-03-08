import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate

object Dependencies {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val material = "com.google.android.material:material:${Versions.material}"


    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val safeNav =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    }

    object Coroutines {
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    }

    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.core}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.AndroidX.swipeRefreshLayout}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val runner = "androidx.test:runner:${Versions.testRunner}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    object Hilt {
        //        implementation "com.google.dagger:hilt-android:$hiltVersion"
//    kapt "com.google.dagger:hilt-android-compiler:$hiltAnnotationProcessor"
        const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val hiltAnnotationProcessor =
            "com.google.dagger:hilt-android-compiler:${Versions.hiltAnnotationProcessor}"
        const val gradlePluginHilt =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.gradlePluginHilt}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }


    object Epoxy {
        const val core = "com.airbnb.android:epoxy:${Versions.epoxy}"
        const val processor = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
        const val databinding = "com.airbnb.android:epoxy-databinding:${Versions.epoxy}"
        const val paging3 = "com.airbnb.android:epoxy-paging3:${Versions.epoxy}"
    }

    object Paging {
        const val runtime =
            "androidx.paging:paging-runtime:${Versions.ArchitectureComponents.paging}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.ArchitectureComponents.room}"
        const val annotation = "androidx.room:room-compiler:${Versions.ArchitectureComponents.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.ArchitectureComponents.room}"
    }

    object Navigation {
        const val navRuntime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
        const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    const val APP = ":app"
    const val FEATURE_HOME = ":feature_home"
    const val FEATURE_FAVORITES = ":feature_favorites"
//    const val FEATURE_PROFILE = ":feature_profile"
//    const val FEATURE_FAVOURITE = ":feature_favourite"
//    const val LIBRARY_TEST_UTILS = ":library_test_utils"

    // False positive" function can be private"
    // See: https://youtrack.jetbrains.com/issue/KT-33610
    /*
    Return list of all modules in the project
     */
}


fun Project.importCommonPlugins() {
    plugins.apply("kotlin-android")
    plugins.apply("kotlin-kapt")
    plugins.apply("kotlin-parcelize")
}

// apply common plugin
fun Project.importCommonDependencies() {
    dependencies {

        // The two following syntax is applicable
        // source: https://github.com/gradle/kotlin-dsl-samples/issues/843
        "implementation"(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        "implementation"(Dependencies.Kotlin.stdLib)


        val implementation by configurations
        val testImplementation by configurations
        val androidTestImplementation by configurations

        implementation(Dependencies.AndroidX.appCompat)
        implementation(Dependencies.AndroidX.coreKtx)
        implementation(Dependencies.AndroidX.constraintLayout)
        implementation(Dependencies.AndroidX.swipeRefreshLayout)
        implementation(Dependencies.material)

        implementation(Dependencies.Coroutines.coroutinesAndroid)
        implementation(Dependencies.Coroutines.coroutinesCore)

        implementation(Dependencies.Retrofit.core)
        implementation(Dependencies.okhttp)
        implementation(Dependencies.Moshi.moshi)

        implementation(Dependencies.Paging.runtime)

        implementation(Dependencies.Navigation.navFragment)
        implementation(Dependencies.Navigation.navRuntime)
        implementation(Dependencies.Navigation.navUi)


        testImplementation(Dependencies.Test.junit)
        androidTestImplementation(Dependencies.Test.runner)
        androidTestImplementation(Dependencies.Test.espressoCore)
    }
}