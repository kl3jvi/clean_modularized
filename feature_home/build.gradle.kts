plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
}

importCommonPlugins()
configAndroid()
importCommonDependencies()


dependencies {
    implementation(project(":app"))

}