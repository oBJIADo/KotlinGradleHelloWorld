val ktVersion = "1.3.11"

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.11")
    }
}

plugins {
    eclipse
    idea
    kotlin("jvm") version "1.3.11"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

tasks.jar {
    baseName = "KotlinGradleTemplate"
    version = "1.0"
    manifest {
        attributes(Pair("Main-Class", "com.tsuyanoshi.gktemplate.HelloWorld"))
    }
}

dependencies {
    testCompile ("org.jetbrains.kotlin:kotlin-test-junit5:$ktVersion")
    compile ("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

//sourceSets {
//    main {
//        java {
//            srcDirs = ['src/main/kt']
//        }
//    }
//}