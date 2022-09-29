package br.edu.infnet.app_quiz_assessment.models
import br.edu.infnet.app_quiz_assessment.models.QuestionsAndOptions


object Constants {
    fun getQuestions(): ArrayList<QuestionsAndOptions> {
        val questionsList = ArrayList<QuestionsAndOptions>()

        // Questão 1
        val que1 = QuestionsAndOptions(
            1,
            "De quem é a famosa frase “Penso, logo existo”?",
            "Platão",
            "Galileu Galilei",
            "Descartes",
            "Sócrates",
            3
        )
        questionsList.add(que1)
        // Questão 2
        val que2 = QuestionsAndOptions(
            2,
            "De onde é a invenção do chuveiro elétrico?",
            "França",
            "Inglaterra",
            "Austrália",
            "Brasil",
            4
        )

        questionsList.add(que2)

        // Questão 3
        val que3 = QuestionsAndOptions(
            3,
            "Qual o nome do presidente do Brasil que ficou conhecido como Jango?",
            "João Goulart",
            "Jacinto Anjos",
            "Getúlio Vargas",
            "Jânio Quadros",
            1
        )

        questionsList.add(que3)

        // Questão 4
        val que4 = QuestionsAndOptions(
            4,
            "O que a palavra legend significa em português?",
            "Legenda",
            "Conto",
            "Legendário",
            "Lenda",
            4
        )

        questionsList.add(que4)

        // Questão 5
        val que5 = QuestionsAndOptions(
            5,
            "Qual o número mínimo de jogadores numa partida de futebol?",
            "8",
            "11",
            "7",
            "5",
            3
        )

        questionsList.add(que5)

        // Questão 6
        val que6 = QuestionsAndOptions(
            6,
            "Quanto tempo a luz do Sol demora para chegar à Terra?",
            "12 horas",
            "8 minutos",
            "12 minutos",
            "1 dia",
            2
        )

        questionsList.add(que6)

        // Questão 7
        val que7 = QuestionsAndOptions(
            7,
            "Qual personagem folclórico costuma ser agradado pelos caçadores com a oferta de fumo?",
            "Caipora",
            "Saci",
            "Boitatá",
            "Negrinho do Pastoreio",
            1
        )

        questionsList.add(que7)

        // Questão 8
        val que8 = QuestionsAndOptions(
            8,
            "“It is six twenty\" ou \"twenty past six”. Que horas são em inglês?",
            "12:06",
            "2:20",
            "6:02",
            "6:20",
            4
        )

        questionsList.add(que8)

        // Questão 9
        val que9 = QuestionsAndOptions(
            9,
            "Quem foi o primeiro homem a pisar na Lua?",
            "Buzz Aldrin",
            "Charles Duke",
            "Neil Armstrong",
            "Charles Conrad",
            3
        )

        questionsList.add(que9)

        // Questão 10
        val que10 = QuestionsAndOptions(
            10,
            "Quais são os cromossomos que determinam o sexo masculino?",
            "Os V",
            "Os X",
            "Os Y",
            "Os W",
            3
        )

        questionsList.add(que10)
        return questionsList
    }
}
