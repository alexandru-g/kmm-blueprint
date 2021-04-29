package com.sv.kmmblueprint.api

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*

object HttpClientFactory {

    fun create() = HttpClient {
        install(JsonFeature)
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
    }
}