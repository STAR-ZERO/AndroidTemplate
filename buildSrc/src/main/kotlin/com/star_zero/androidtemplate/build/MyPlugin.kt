package com.star_zero.androidtemplate.build

import com.android.build.api.dsl.ApplicationBuildFeatures
import com.android.build.api.dsl.DynamicFeatureBuildFeatures
import com.android.build.api.dsl.LibraryBuildFeatures
import com.android.build.gradle.*
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsFeature
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class MyPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.withType(AppPlugin::class.java) {
            val extension = project.extensions.getByName("android") as BaseAppModuleExtension
            setupCommon(project, extension)
        }

        project.plugins.withType(LibraryPlugin::class.java) {
            val extension = project.extensions.getByName("android") as LibraryExtension
            setupCommon(project, extension)
            setupLibraryProject(extension)
        }

        project.plugins.withType(DynamicFeaturePlugin::class.java) {
            val extension = project.extensions.getByName("android") as AppExtension
            setupCommon(project, extension)
            setupDynamicFeatureProject(extension)
        }
    }

    private fun setupCommon(project: Project, extension: BaseExtension) {
        extension.apply {
            compileSdkVersion(AndroidConfigurations.COMPILE_SDK_VERSION)
            defaultConfig {
                minSdk = AndroidConfigurations.MIN_SDK_VERSION
                targetSdk = AndroidConfigurations.TARGET_SDK_VERSION
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions.apply {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            // DataBinding
            when (val features = buildFeatures) {
                is ApplicationBuildFeatures -> features.dataBinding = true
                is DynamicFeatureBuildFeatures -> features.dataBinding = true
                is LibraryBuildFeatures -> features.dataBinding = true
            }
        }

        // kotlin
        project.tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions.jvmTarget = "1.8"
        }

        // Use only "parcelize" (except "views")
        project.extensions.findByType(AndroidExtensionsExtension::class.java)?.apply {
            features = setOf(AndroidExtensionsFeature.PARCELIZE.featureName)
        }
    }

    private fun setupLibraryProject(extension: LibraryExtension) {
        extension.apply {
            defaultConfig {
                consumerProguardFiles("consumer-rules.pro")
            }

            // Don't create BuildConfig in library module
            libraryVariants.all {
                generateBuildConfigProvider.configure {
                    enabled = false
                }
            }
        }
    }

    private fun setupDynamicFeatureProject(extension: AppExtension) {
        extension.apply {
            buildTypes.getByName("release").apply {
                proguardFiles("proguard-rules-dynamic-features.pro")
            }

            // Don't create BuildConfig in dynamic feature module
            applicationVariants.all {
                generateBuildConfigProvider.configure {
                    enabled = false
                }
            }
        }
    }
}
