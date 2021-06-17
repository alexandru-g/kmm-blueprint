package com.sv.kmmblueprint.db

import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionDao {

    private val db: Database by lazy { Database(DriverFactory.create()) }

    fun getQuestions(): Flow<List<Question>> =
        db.questionQueries.getQuestions().asFlow().map { it.executeAsList() }

    fun getQuestions(difficulty: String): Flow<List<Question>> =
        db.questionQueries.getQuestionByDifficulty(difficulty).asFlow().map { it.executeAsList() }

    fun getQuestion(question: String): Question =
        db.questionQueries.getQuestion(question).executeAsOne()

    fun insert(question: Question) = db.questionQueries.insert(question)

    fun update(question: Question) = db.questionQueries.update(
        question = question.question,
        category = question.category,
        type = question.type,
        difficulty = question.difficulty,
        correctAnswer = question.correctAnswer
    )
}