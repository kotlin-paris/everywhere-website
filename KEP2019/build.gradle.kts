plugins {
    kotlin("js")
}

kotlin {
    target {
        browser()
        nodejs()

        compilations["main"].kotlinOptions {
            moduleKind = "commonjs"
        }
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.2.2")

        val wrapperVersion = "pre.82-kotlin-1.3.41"

        implementation("org.jetbrains:kotlin-react-dom:16.9.0-$wrapperVersion")
        implementation("org.jetbrains:kotlin-react-router-dom:4.3.1-$wrapperVersion")
        implementation("org.jetbrains:kotlin-styled:1.0.0-$wrapperVersion")

        implementation(npm("react", "^16.9.0"))
        implementation(npm("react-router", "^4.3.1"))
        implementation(npm("react-router-dom", "^4.3.1"))
        implementation(npm("react-dom", "^16.9.0"))

        implementation(npm("css-in-js-utils", "^3.0.2"))
        implementation(npm("inline-style-prefixer", "^5.1.0"))
        implementation(npm("styled-components", "^4.3.2"))
        implementation(npm("core-js", "^3.0.0"))

        implementation(npm("react-transition-group", "4.2.2"))
    }
}

//task<Sync>("copyResources") {
//    group = "build"
//    dependsOn("browserWebpack")
//
//    from("src/main/resources", "$buildDir/libs/${project.name}.js")
//    into("$projectDir/docs")
//}
//
//tasks.getByName("assemble").dependsOn("copyResources")
