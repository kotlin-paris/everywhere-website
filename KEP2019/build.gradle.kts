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

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.0")

        val reactVersion = "16.9.0"
        val reactRouterVersion = "4.3.1"
        val kotlinWrapperVersion = "pre.83-kotlin-1.3.41"

        api("org.jetbrains:kotlin-react-dom:$reactVersion-$kotlinWrapperVersion")
        api("org.jetbrains:kotlin-react-router-dom:$reactRouterVersion-$kotlinWrapperVersion")
        implementation("org.jetbrains:kotlin-styled:1.0.0-$kotlinWrapperVersion")

        implementation(npm("react", "^$reactVersion"))
        implementation(npm("react-dom", "^$reactVersion"))
        implementation(npm("react-router", "^$reactRouterVersion"))
        implementation(npm("react-router-dom", "^$reactRouterVersion"))

        implementation(npm("css-in-js-utils", "^3.0.2"))
        implementation(npm("inline-style-prefixer", "^5.1.0"))
        implementation(npm("styled-components", "^4.3.2"))
        implementation(npm("core-js", "^3.0.0"))
    }
}
