package com.sv.kmmblueprint.ui.quiz

import com.sv.kmmblueprint.model.api.Question
import com.sv.kmmblueprint.util.CommonFlow

interface QuizViewModel {

    val questions: CommonFlow<List<Question>>

    fun deinit()
}