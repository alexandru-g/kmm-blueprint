//
//  QuizViewModel.swift
//  iosApp
//
//  Created by Alexandru Gherghina on 29.04.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

class QuizViewModel: ObservableObject {
    
    private let common = QuizViewModelImpl()
    
    @Published var questions: [QuestionEntry] = []
    
    init() {
        common.questions.watch { questions in
            self.questions = (questions as? [Question])?.map { question in
                let answers: [String] = [question.correctAnswer as String? ?? ""] + question.incorrectAnswers
                return QuestionEntry(id: question.question, question: question.question, answers: answers)
            } ?? []
        }
    }
    
    deinit {
        common.deinit()
    }
}
