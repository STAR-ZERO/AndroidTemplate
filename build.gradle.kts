buildscript {
    apply(from = "buildSrc/build_dependencies.gradle.kts")
    apply<MyRootPlugin>()

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Deps.ANDROID_GRADLE_PLUGIN)
        classpath(Deps.KOTLIN_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
