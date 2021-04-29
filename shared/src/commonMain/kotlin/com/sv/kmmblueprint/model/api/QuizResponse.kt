package com.sv.kmmblueprint.model.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizResponse(
    @SerialName("response_code") val responseCode: Int,
    val results: List<Question>
)
