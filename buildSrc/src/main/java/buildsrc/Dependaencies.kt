package buildsrc

object Plugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradle}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

object Libs {
    object Accompanist {
        val insets by lazy { "com.google.accompanist:accompanist-insets:${Versions.accompanist}" }
        val systemuicontroller by lazy { "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}" }
        val flowlayouts by lazy { "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}" }
    }

    object Kotlin {
        val stdlib by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}" }
        val gradlePlugin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
        val extensions by lazy { "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}" }
    }

    object Coroutines {
        val core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}" }
        val android by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}" }
        val test by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}" }
    }

    object Coil {
        val coilCompose by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }
    }
}