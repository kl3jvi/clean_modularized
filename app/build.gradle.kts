plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    kotlin("kapt")
}

importCommonPlugins()
configAndroid()
importCommonDependencies()

android {
    defaultConfig {
        applicationId = Versions.App.id

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
                argument("enableParallelEpoxyProcessing", "true")
            }
        }
    }

    setDynamicFeatures(
        mutableSetOf(
            Dependencies.FEATURE_HOME,
            Dependencies.FEATURE_FAVORITES
        )
    )

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }


}


dependencies {

    implementation(Dependencies.dynamicFeaturePlugin)
    implementation(Dependencies.coil)

    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    "kapt"(Dependencies.Room.annotation)


    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLogging)
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.moshiConverter)

    implementation(Dependencies.Hilt.hilt)
    "kapt"(Dependencies.Hilt.hiltAnnotationProcessor)

    implementation(Dependencies.Moshi.moshi)
    "kapt"(Dependencies.Moshi.moshiKapt)

    api(Dependencies.Navigation.navUi)
    api(Dependencies.Navigation.navRuntime)
    api(Dependencies.Navigation.navFragment)
}
