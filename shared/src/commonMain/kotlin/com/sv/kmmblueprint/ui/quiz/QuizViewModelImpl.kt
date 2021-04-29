package com.sv.kmmblueprint.ui.quiz

import com.sv.kmmblueprint.api.Repository
import com.sv.kmmblueprint.model.api.Question
import com.sv.kmmblueprint.util.CommonFlow
import com.sv.kmmblueprint.util.asCommonFlow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

class QuizViewModelImpl : QuizViewModel {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val repository = Repository()

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    override val questions: CommonFlow<List<Question>> = _questions.asCommonFlow()

    init {
        coroutineScope.launch {
            _questions.value = repository.getQuestions().results
        }
    }

    override fun deinit() {
        coroutineScope.cancel()
    }
}