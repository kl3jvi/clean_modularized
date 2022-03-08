plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

importCommonPlugins()
configAndroid()
importCommonDependencies()


dependencies {
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
}