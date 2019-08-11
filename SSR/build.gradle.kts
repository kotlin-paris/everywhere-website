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

        val wrapperVersion = "pre.82-kotlin-1.3.41"

        implementation("org.jetbrains:kotlin-react-dom:16.9.0-$wrapperVersion")

        implementation(npm("react", "^16.9.0"))
        implementation(npm("react-dom", "^16.9.0"))
    }
}

//task<NodeJsExec>("generateHtml") {
//    dependsOn(":nodeRun")
//
//    afterEvaluate {
//        println(tasks["nodeRun"].dup)
//    }
//}

NodeJsExec.create(kotlin.target.compilations["main"], "generateHtml") {
    val outputFile = file("$buildDir/generated/index.html")
    outputs.file(outputFile)

    doFirst {
        outputFile.parentFile.mkdirs()
        standardOutput = outputFile.outputStream()
    }
}