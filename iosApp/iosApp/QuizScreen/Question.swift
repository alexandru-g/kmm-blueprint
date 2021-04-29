//
//  Question.swift
//  iosApp
//
//  Created by Alexandru Gherghina on 29.04.2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct QuestionEntry: Identifiable {
    var id: String
    var question: String
    var answers: [String]
}

struct QuestionView: View {
    var question: QuestionEntry
    
    var body: some View {
        VStack {
            Text(self.question.question)
                .padding()
            ForEach(self.question.answers, id: \.self) { answer in
                Text(answer)
                    .padding()
            }
        }
    }
}

struct QuestionView_Previews: PreviewProvider {
    static var previews: some View {
        QuestionView(question: QuestionEntry(id: "test", question: "Test question", answers: ["Answer 1", "Answer 2"]))
    }
}
