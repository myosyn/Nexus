/*
 * This file is part of Nexus, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 Myosyn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

plugins {
    id("java-library")
    `maven-publish`
    `kotlin-dsl`
    groovy
}

gradlePlugin {
    plugins {
        create("com.github.myosyn.nexus.reprocess") {
            id = "com.github.myosyn.nexus.reprocess"
            implementationClass = "com.github.myosyn.nexus.reprocess.gradle.plugin.preprocessorPlugin"
            displayName = "preprocessor"
            description = "Add multiple bots within a single repository with ease."
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    implementation("com.guardsquare:proguard-gradle:7.2.2")
    implementation("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.4.2")
    implementation("")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.shuuyu"
            artifactId = "Nexus"
            version = "IDK"

            from(components["java"])
        }
    }
    repositories {
        maven("https://maven.shuuyu.live/release") {
            name = "releases"
            credentials {

            }
        }
    }
}