plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply<MyPlugin>()

dependencies {
    implementation(project(":core"))
    implementation(project(":app"))

    testImplementation(Deps.JUNIT)
    androidTestImplementation(Deps.TEST_EXT)
    androidTestImplementation(Deps.ESPRESSO)
}
