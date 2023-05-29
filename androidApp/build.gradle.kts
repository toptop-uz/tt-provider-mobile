import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "com.toptop.provider.android"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.toptop.provider.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        val keystorePropertiesFile = rootProject.file("key.properties")
        val keystoreProperties = Properties()

        if (keystorePropertiesFile.exists()) {
            keystoreProperties.load(FileInputStream(keystorePropertiesFile))
        }

        create("release") {
            keyAlias = (keystoreProperties["keyAlias"] as? String).orEmpty()
            keyPassword = (keystoreProperties["keyPassword"] as? String).orEmpty()
            storeFile = file((keystoreProperties["storeFile"] as? String).orEmpty())
            storePassword = (keystoreProperties["storePassword"] as? String).orEmpty()
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val outputFileName = "tt-provider-$versionName.apk"
                output.outputFileName = outputFileName
            }
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(libs.kotlin.coroutines)
    implementation(libs.ktor.android)
    implementation(libs.kmm.viewmodel)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.viewModel)
    implementation(libs.androidx.lifecycle.runtime)

    implementation(libs.compose.activity)
    implementation(libs.compose.lifecycle)
    implementation(libs.compose.runtime)
    implementation(libs.compose.compiler)
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)

    implementation(libs.google.material)
    implementation(libs.google.playservices.location)
    implementation(libs.google.playservices.auth)
    implementation(libs.google.playservices.phone)
    implementation(platform(libs.google.firebase.bom))
    implementation(libs.google.firebase.crashlytics)
    implementation(libs.google.firebase.analytics)

    implementation(libs.koin.core)
    implementation(libs.koin.android)

    implementation(libs.odyssey.core)
    implementation(libs.odyssey.compose)
}