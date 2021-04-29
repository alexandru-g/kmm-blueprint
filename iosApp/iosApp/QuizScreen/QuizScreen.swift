//
//  QuizScreen.swift
//  iosApp
//
//  Created by Alexandru Gherghina on 29.04.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct QuizScreen: View {
    
    @ObservedObject var viewModel = QuizViewModel()
    
    var body: some View {
        ScrollView {
            LazyVStack(spacing: 10) {
                ForEach(viewModel.questions) { question in
                    QuestionView(question: question)
                }
            }
        }
    }
}
