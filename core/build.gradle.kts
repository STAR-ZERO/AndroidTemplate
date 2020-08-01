plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

apply<MyPlugin>()

dependencies {
    api(Deps.KOTLIN)
    api(Deps.ANDROIDX_CORE)
    api(Deps.APPCOMPAT)
    api(Deps.MATERIAL)
    api(Deps.CONSTRAINT)

    testImplementation(Deps.JUNIT)
    androidTestImplementation(Deps.TEST_EXT)
    androidTestImplementation(Deps.ESPRESSO)
}
