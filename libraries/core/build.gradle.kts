plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dataBinding.isEnabled = true
    viewBinding.isEnabled = true
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    importCommonDependencies()

    //UNIQUE PER MODULE
    implementation(Dependencies.coil)
    implementation(Dependencies.Koin.koin)


    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLogging)
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.moshiConverter)
    implementation(Dependencies.Moshi.moshi)
    "kapt"(Dependencies.Moshi.moshiKapt)
}