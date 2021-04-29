package com.sv.kmmblueprint.android.ui.quiz

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sv.kmmblueprint.model.api.Question

@Composable
fun QuizScreen() {
    val viewModel: QuizAndroidViewModel = viewModel()
    val questions: List<Question> by viewModel.questions.collectAsState(initial = emptyList())

    QuizScreenContent(questions)
}

@Composable
fun QuizScreenContent(questions: List<Question>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
    ) {
        items(items = questions, itemContent = { question ->
            QuizQuestion(question = question) {
                Log.d("QuizScreenContent", "answer clicked: $it")
            }
        })
    }
}