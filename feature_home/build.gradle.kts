plugins {
    id(ANDROID_DYNAMIC_FEATURE_PLUGIN)
    id(KOTLIN_ANDROID_PLUGIN)
    id(KOTLIN_KAPT_PLUGIN)
}


android {

    compileSdk = (Versions.Android.sdk)

    defaultConfig {
        minSdk = 21
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

    packagingOptions {
        exclude("META-INF/AL2.0")
    }

    dataBinding.isEnabled = true
    viewBinding.isEnabled = true
}

dependencies {
    importCommonDependencies()
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(Dependencies.DynamicFeature.APP))

    implementation(project(Dependencies.AndroidLibrary.DATA_API))
    implementation(project(Dependencies.AndroidLibrary.DOMAIN))

//    implementation(Dependencies.Lifecycle.lifecycleExt)
//    implementation(Dependencies.Lifecycle.lifecycleViewModel)
    implementation(Dependencies.Lifecycle.lifecycleRuntime)
    "kapt"(Dependencies.Lifecycle.lifecycleKapt)

    implementation(Dependencies.coil)

    implementation(Dependencies.Koin.koin)
}