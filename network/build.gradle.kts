plugins {
    id("androidLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(libs.retrofit)
    implementation(libs.moshi.converter)
    implementation(libs.data.store)

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    api(projects.datastore)
}
