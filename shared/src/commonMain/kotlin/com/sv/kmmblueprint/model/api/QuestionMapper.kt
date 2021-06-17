package com.sv.kmmblueprint.model.api

object QuestionMapper {
    fun map(question: Question) = com.sv.kmmblueprint.db.Question(
        question = question.question,
        category = question.category,
        type = question.type,
        difficulty = question.difficulty,
        correctAnswer = question.correctAnswer
    )

    fun map(question: com.sv.kmmblueprint.db.Question) = Question(
        question = question.question,
        category = question.category,
        type = question.type,
        difficulty = question.difficulty,
        correctAnswer = question.correctAnswer,
        incorrectAnswers = emptyList()
    )
}