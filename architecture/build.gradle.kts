plugins {
    id("androidLibrary")
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.android.components)
    implementation(libs.bundles.network)
    implementation(libs.hilt.android)
}