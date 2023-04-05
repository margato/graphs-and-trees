version = "0.1"
group = "io.github.margato.graphs"

val kotlinVersion = project.properties["kotlinVersion"]
val kotestVersion = "5.5.5"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("org.jetbrains.kotlin.kapt") version "1.7.20"
    id("info.solidsoft.pitest") version "1.9.11"
}

dependencies {
    implementation("io.github.microutils:kotlin-logging:1.7.4")
    implementation("org.slf4j:slf4j-simple:1.7.26")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest.extensions:kotest-extensions-pitest:1.2.0")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    test {
        finalizedBy (pitest)
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

configure<info.solidsoft.gradle.pitest.PitestPluginExtension> {
    targetClasses.set(setOf("io.github.margato.graphs.*"))
    targetTests.set(setOf("io.github.margato.graphs.*"))

    mutationThreshold.set(75)
    coverageThreshold.set(60)
    outputFormats.set(setOf("HTML"))
}