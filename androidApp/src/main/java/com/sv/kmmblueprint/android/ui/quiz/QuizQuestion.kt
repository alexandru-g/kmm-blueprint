package com.sv.kmmblueprint.android.ui.quiz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sv.kmmblueprint.model.api.Question

@Composable
fun QuizQuestion(question: Question, onAnswerClicked: (String) -> Unit) {
    Column {
        Text(text = question.question)

        Text(
            modifier = Modifier
                .clickable { onAnswerClicked(question.correctAnswer) }
                .padding(8.dp),
            text = question.correctAnswer
        )
        question.incorrectAnswers.forEach {
            Text(
                modifier = Modifier
                    .clickable { onAnswerClicked(it) }
                    .padding(8.dp),
                text = it
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        QuizQuestion(
            question = Question(
                category = "Game Questions",
                type = "boolean",
                difficulty = "easy",
                question = "Oare va merge Compose pe iOS?",
                correctAnswer = "False",
                incorrectAnswers = listOf("True")
            ),
            onAnswerClicked = {}
        )
    }
}