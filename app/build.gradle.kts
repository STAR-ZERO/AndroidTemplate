plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply<MyPlugin>()

android {
    defaultConfig {
        applicationId = "com.star_zero.androidtemplate"
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    dynamicFeatures = mutableSetOf(":dynamicfeature")
}

dependencies {
    implementation(project(":core"))

    testImplementation(Deps.JUNIT)
    androidTestImplementation(Deps.TEST_EXT)
    androidTestImplementation(Deps.ESPRESSO)
}
