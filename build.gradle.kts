//import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
//import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    kotlin("js") version "1.3.40"
//    id("org.jetbrains.kotlin.frontend") version "0.0.45"
//    id("kotlin-dce-js")
}

repositories {
    maven( url = "https://kotlin.bintray.com/kotlin-js-wrappers")
    jcenter()
}

kotlin {
    target {
        browser()

        compilations["main"].kotlinOptions {
            moduleKind = "commonjs"
        }
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))

        val wrapperVersion = "pre.72-kotlin-1.3.31"

        implementation("org.jetbrains:kotlin-react-dom:16.6.0-$wrapperVersion")
        implementation("org.jetbrains:kotlin-react-router-dom:4.3.1-$wrapperVersion")
        implementation("org.jetbrains:kotlin-styled:1.0.0-$wrapperVersion")

        implementation(npm("react", "^16.6.0"))
        implementation(npm("react-dom", "^16.6.0"))
        implementation(npm("react-router", "^4.3.1"))
        implementation(npm("react-router-dom", "^4.3.1"))

        implementation(npm("css-in-js-utils", "^2.0.1"))
        implementation(npm("inline-style-prefixer", "^5.0.1"))
        implementation(npm("styled-components", "^3.4.6"))

        implementation(npm("core-js", "^3.0.0"))
    }
}

task<Sync>("copyResources") {
    group = "build"
    dependsOn("browserWebpack")

    from("src/main/resources", "$buildDir/libs/${project.name}.js")
    into("$projectDir/docs")
}

tasks.getByName("assemble").dependsOn("copyResources")
