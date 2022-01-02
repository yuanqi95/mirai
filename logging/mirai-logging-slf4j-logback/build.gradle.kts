/*
 * Copyright 2019-2022 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

@file:Suppress("UnusedImport")

plugins {
    kotlin("jvm")
    id("java")
    `maven-publish`
}

version = Versions.core
description = "Mirai SLF4J Adapter with logback-classic"

kotlin {
    explicitApi()
}

dependencies {
    api(project(":mirai-core-api"))
    api(project(":mirai-logging-slf4j")) // mirai -> slf4j
    implementation(project(":mirai-logging-log4j2")) {
        exclude("org.apache.logging.log4j", "log4j-slf4j-impl")
    } // mirai -> log4j2
    api(`slf4j-api`)
    api(`logback-classic`)

    testImplementation(project(":mirai-core"))
    testImplementation(project(":mirai-core-utils"))
}

configurePublishing("mirai-logging-slf4j-logback")