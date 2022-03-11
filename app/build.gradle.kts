plugins {
    id(ANDROID_APPLICATION_PLUGIN)
    id(KOTLIN_ANDROID_PLUGIN)
    id(KOTLIN_KAPT_PLUGIN)
    id(NAVIGATION_SAFE_ARGS)
}


importCommonDependencies()

android {
    defaultConfig {
        applicationId = Versions.App.id
        compileSdk = Versions.Android.sdk
        minSdk = Versions.Android.minSdk
        targetSdk = Versions.Android.sdk
        versionCode = Versions.App.versionCode
        versionName = Versions.App.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // TODO Scheme is  created in data module but with which one, find out
        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] = "$projectDir/schemas"
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    dynamicFeatures.apply {
        add(Dependencies.DynamicFeature.FEATURE_HOME)
        add(Dependencies.DynamicFeature.FEATURE_FAVORITES)
    }


    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


dependencies {

    implementation(Dependencies.dynamicFeaturePlugin)
    implementation(Dependencies.coil)

    implementation(project(Dependencies.AndroidLibrary.CORE))
    implementation(project(Dependencies.AndroidLibrary.DATA_API))

    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    "kapt"(Dependencies.Room.annotation)


    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLogging)
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.moshiConverter)

    implementation(Dependencies.Koin.koin)


    implementation(Dependencies.Moshi.moshi)
    "kapt"(Dependencies.Moshi.moshiKapt)

    api(Dependencies.Navigation.navUi)
    api(Dependencies.Navigation.navRuntime)
    api(Dependencies.Navigation.navFragment)
}
