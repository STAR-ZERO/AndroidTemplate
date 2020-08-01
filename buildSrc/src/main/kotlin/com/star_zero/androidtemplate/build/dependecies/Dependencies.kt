package com.star_zero.androidtemplate.build.dependecies

object Dependencies {
    val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"

    val KOTLIN_COMMON = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.KOTLIN}"
    val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    const val ANDROIDX_CORE = "androidx.core:core-ktx:1.3.1"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.3.0-alpha01"

    private const val NAVIGATION_VERSION = "2.3.0"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"

    const val MATERIAL = "com.google.android.material:material:1.3.0-alpha02"

    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout:2.0.0-beta8"

    const val JUNIT = "junit:junit:4.13"
    const val TEST_EXT = "androidx.test.ext:junit:1.1.2-rc01"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:3.3.0-rc01"
}
