plugins {
    id("androidLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.data.store)

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)
}
