package com.sv.kmmblueprint.api

import com.sv.kmmblueprint.model.api.QuizResponse
import io.ktor.client.request.*

class Repository {

    suspend fun getQuestions(): QuizResponse {
        val client = HttpClientFactory.create()

        val response: QuizResponse = client.get("https://opentdb.com/api.php?amount=10")

        return response
    }
}