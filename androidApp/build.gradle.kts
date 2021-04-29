plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    val kotlinVersion = "1.4.30"
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    val compose = "1.0.0-beta03"
    implementation("androidx.compose.runtime:runtime:$compose")
    implementation("androidx.compose.ui:ui:$compose")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:$compose")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$compose")
    // Material Design
    implementation("androidx.compose.material:material:$compose")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$compose")
    implementation("androidx.compose.material:material-icons-extended:$compose")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.3.0-alpha05")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:$compose")

    implementation("androidx.navigation:navigation-compose:1.0.0-alpha09")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.sv.kmmblueprint.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta01"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        freeCompilerArgs += "-Xopt-in=kotlin.Experimental"
    }
}