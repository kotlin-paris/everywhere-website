import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

buildscript {
    repositories {
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
    }
}

subprojects {
    repositories {
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        maven( url = "https://kotlin.bintray.com/kotlin-js-wrappers")
        jcenter()
    }
}

evaluationDependsOn(":WEB")

task<Sync>("buildDocs") {
    val processReouces = project(":WEB").tasks["processResources"]
    val browserWebpack = project(":WEB").tasks["browserWebpack"]

    dependsOn(processReouces, browserWebpack)

    into(rootDir.resolve("docs"))

    from(processReouces.outputs.files)

    from((browserWebpack as KotlinWebpack).archiveFile)
}
