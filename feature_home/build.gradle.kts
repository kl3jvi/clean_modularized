plugins {
    id(ANDROID_DYNAMIC_FEATURE_PLUGIN)
    id(KOTLIN_ANDROID_PLUGIN)
    id(KOTLIN_KAPT_PLUGIN)
//    id(DAGGER_HILT_PLUGIN)
}


android {

    compileSdk = (Versions.Android.sdk)

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}




dependencies {
    importCommonDependencies()
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(Dependencies.DynamicFeature.APP))
    implementation(project(Dependencies.AndroidLibrary.CORE))
    implementation(project(Dependencies.AndroidLibrary.DATA))
    implementation(project(Dependencies.AndroidLibrary.DATA_API))
}