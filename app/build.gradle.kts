plugins {
    id("com.android.application")
}

android {
    namespace = "com.contextsmali.xrandroidnativesettings"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.contextsmali.xrandroidnativesettings"
        minSdk = 23
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}
