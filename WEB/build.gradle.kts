plugins {
    kotlin("js")
}

version = ""

kotlin {
    target {
        browser {
            webpackTask {
                sourceMaps = false
            }
        }

        compilations["main"].kotlinOptions {
            moduleKind = "commonjs"
        }
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))

        implementation(project(":KEP2019"))
    }
}

evaluationDependsOn(":SSR")
evaluationDependsOn(":KEP2019")
(tasks[kotlin.target.compilations["main"].processResourcesTaskName] as ProcessResources).apply {
    dependsOn(":SSR:generateHtml")
    from(project(":SSR").tasks["generateHtml"].outputs.files)

    from(project(":KEP2019").projectDir.resolve("src/main/resources/"))
}
