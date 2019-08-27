import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsExec

plugins {
    kotlin("js")
}

kotlin {
    target {
        nodejs()

        compilations["main"].kotlinOptions {
            moduleKind = "commonjs"
        }
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))

        implementation(project(":KEP2019"))
    }
}

NodeJsExec.create(kotlin.target.compilations["main"], "generateHtml") {
    val outputFile = file("$buildDir/generated/index.html")
    outputs.file(outputFile)

    doFirst {
        outputFile.parentFile.mkdirs()
        standardOutput = outputFile.outputStream()
    }
}