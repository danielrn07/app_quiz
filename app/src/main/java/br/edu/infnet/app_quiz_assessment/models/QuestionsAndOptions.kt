package br.edu.infnet.app_quiz_assessment.models

data class QuestionsAndOptions(
    val id: Int,
    var pergunta: String,
    var option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: Int
)
