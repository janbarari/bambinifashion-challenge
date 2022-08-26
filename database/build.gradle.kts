plugins {
    id("androidLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.bundles.kotlin)

    api(libs.room.runtime)
    kapt(libs.room.kapt)

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)
}