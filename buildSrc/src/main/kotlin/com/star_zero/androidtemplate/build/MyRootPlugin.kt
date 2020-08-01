package com.star_zero.androidtemplate.build

import com.star_zero.androidtemplate.build.dependecies.Versions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtraPropertiesExtension

class MyRootPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Read from buildSrc/build_dependencies.gradle.kts
        val ext = project.property("ext") as ExtraPropertiesExtension
        Versions.androidGradlePlugin = ext["android_gradle_plugin_version"] as String
        Versions.kotlin = ext["kotlin_version"] as String
    }
}
