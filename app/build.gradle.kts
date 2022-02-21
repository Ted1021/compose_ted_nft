import buildsrc.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

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

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.Activity.activityCompose)
    implementation(Libs.AndroidX.Lifecycle.viewModelCompose)
    implementation(Libs.AndroidX.Navigation.navigationCompose)
    implementation(Libs.AndroidX.ConstraintLayout.constraintLayoutCompose)

    implementation(Libs.AndroidX.Compose.runtime)
    implementation(Libs.AndroidX.Compose.foundation)
    implementation(Libs.AndroidX.Compose.layout)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.uiUtil)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.animation)
    implementation(Libs.AndroidX.Compose.iconsExtended)
    implementation(Libs.AndroidX.Compose.toolingPreview)
    debugImplementation(Libs.AndroidX.Compose.tooling)

    androidTestImplementation(Libs.JUnit.junit)
    androidTestImplementation(Libs.AndroidX.Test.core)
    androidTestImplementation(Libs.AndroidX.Test.runner)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
    androidTestImplementation(Libs.AndroidX.Test.rules)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.Coroutines.test)
    androidTestImplementation(Libs.AndroidX.Compose.uiTest)

    implementation(Libs.Coil.coilCompose)

}