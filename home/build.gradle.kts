plugins {
    id("androidLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
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

    implementation(libs.picasso)

    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.3")

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    implementation(libs.moshi.kotlin)
    kapt(libs.moshi.codegen)

    api(projects.architecture)
    api(projects.network)
    api(projects.database)
    api(projects.designsystem)
}
