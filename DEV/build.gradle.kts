plugins {
    kotlin("js")
}

version = ""

kotlin {
    target {
        browser()

        compilations["main"].kotlinOptions {
            moduleKind = "commonjs"
        }
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))

        implementation(project(":KEP2019"))
    }
}

evaluationDependsOn(":KEP2019")
(tasks[kotlin.target.compilations["main"].processResourcesTaskName] as ProcessResources).apply {
    from(project(":KEP2019").projectDir.resolve("src/main/resources/"))
}
