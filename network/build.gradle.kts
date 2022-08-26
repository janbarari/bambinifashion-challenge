plugins {
    id("androidLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(libs.retrofit)
    api(libs.moshi.converter)
    implementation(libs.okhttp.interceptor)

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    api(projects.datastore)
}
