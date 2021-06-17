package com.sv.kmmblueprint.ui.quiz

import com.sv.kmmblueprint.api.Repository
import com.sv.kmmblueprint.db.QuestionDao
import com.sv.kmmblueprint.model.api.Question
import com.sv.kmmblueprint.model.api.QuestionMapper
import com.sv.kmmblueprint.util.CommonFlow
import com.sv.kmmblueprint.util.asCommonFlow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class QuizViewModelImpl : QuizViewModel {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val repository = Repository()
    private val questionDao = QuestionDao()

    override val questions: CommonFlow<List<Question>>
        = questionDao.getQuestions()
        .map { it.shuffled().takeLast(10).map(QuestionMapper::map) }
        .flowOn(Dispatchers.Default)
        .asCommonFlow()

    init {
        coroutineScope.launch {
            try {
                val networkQuestions = repository.getQuestions().results
                networkQuestions.forEach {
                    questionDao.insert(QuestionMapper.map(it))
                }
            } catch (ignored: Exception) {}
        }
    }

    override fun deinit() {
        coroutineScope.cancel()
    }
}