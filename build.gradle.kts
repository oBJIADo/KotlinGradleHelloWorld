buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(kotlin(module = "gradle-plugin", version = "1.3.61"))
        classpath(kotlin(module = "allopen", version = "1.3.61"))
    }
}

plugins {
    idea

    kotlin("jvm") version "1.3.61"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

repositories {
    mavenCentral()

    maven {
        setUrl("https://mvnrepository.com/repos/springio-plugins-release/")
    }
}

tasks.jar {
    baseName = "temlpate"
    version = "1.0"
    manifest {
        attributes(Pair("Main-Class", "com.tsuyanoshi.gktemplate.Template"))
    }
}

dependencies {
    val ktVersion = "1.3.61"
    val ktGroup = "org.jetbrains.kotlin"

    val coroutinesVersion = "1.3.3"
    val coroutinesGroup = "org.jetbrains.kotlinx"

    testCompile(group = ktGroup, name = "kotlin-test-junit5", version = ktVersion)
    compile(group = ktGroup, name = "kotlin-stdlib-jdk8", version = ktVersion)
    compile(group = ktGroup, name = "kotlin-reflect", version = ktVersion)
    compile(group = ktGroup, name = "kotlin-reflect", version = ktVersion)

    compile(group = coroutinesGroup, name = "kotlinx-coroutines-core", version = coroutinesVersion)
    compile(group = coroutinesGroup, name = "kotlinx-coroutines-core-common", version = coroutinesVersion)
    compile(group = coroutinesGroup, name = "kotlinx-coroutines-jdk8", version = coroutinesVersion)
}