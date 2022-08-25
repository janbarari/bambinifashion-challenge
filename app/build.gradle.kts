plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.bambinifashion"
        minSdk = 25
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.android.components)
    implementation(libs.bundles.network)

    implementation(libs.bundles.navigation.component)

    testImplementation(libs.bundles.unit.test)
    androidTestImplementation(libs.bundles.android.test)

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)
}
