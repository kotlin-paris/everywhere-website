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

        val wrapperVersion = "pre.82-kotlin-1.3.41"

        implementation("org.jetbrains:kotlin-react-dom:16.9.0-$wrapperVersion")
        implementation("org.jetbrains:kotlin-react-router-dom:4.3.1-$wrapperVersion")

        implementation(npm("react", "^16.9.0"))
        implementation(npm("react-dom", "^16.9.0"))
        implementation(npm("react-router", "^4.3.1"))
        implementation(npm("react-router-dom", "^4.3.1"))

        implementation(npm("css-in-js-utils", "^3.0.2"))
        implementation(npm("inline-style-prefixer", "^5.1.0"))
        implementation(npm("styled-components", "^4.3.2"))

        implementation(npm("core-js", "^3.0.0"))
    }
}

evaluationDependsOn(":WEB")

(tasks[kotlin.target.compilations["main"].processResourcesTaskName] as ProcessResources).apply {
    from(project(":WEB").projectDir.resolve("src/main/resources/"))
}
