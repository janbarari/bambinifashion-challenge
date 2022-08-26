plugins {
    id("androidLibrary")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.android.components)
    implementation(libs.bundles.navigation.component)
    androidTestImplementation(libs.bundles.android.test)
    implementation(projects.architecture)
}
