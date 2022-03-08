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

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }


}


dependencies {

    implementation(Dependencies.Epoxy.core)
    implementation(Dependencies.Epoxy.paging3)
    implementation(Dependencies.Epoxy.databinding)
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.4.1")
    "kapt"(Dependencies.Epoxy.processor)

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
