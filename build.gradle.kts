plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.jjoon"
version = "0.0.1-ALPHA"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}