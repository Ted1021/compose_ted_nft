import buildsrc.*

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.developer.ted.teddynft"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
//        release {
//            minifyEnabled = false
//            proguardFiles = getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
//        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Libs.Accompanist.insets)
}