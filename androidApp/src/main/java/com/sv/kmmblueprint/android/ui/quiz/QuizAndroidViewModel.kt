package com.sv.kmmblueprint.android.ui.quiz

import androidx.lifecycle.ViewModel
import com.sv.kmmblueprint.ui.quiz.QuizViewModel
import com.sv.kmmblueprint.ui.quiz.QuizViewModelImpl

class QuizAndroidViewModel : ViewModel(), QuizViewModel by QuizViewModelImpl() {

    override fun onCleared() {
        deinit()
    }
}