package br.edu.infnet.app_quiz_assessment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import br.edu.infnet.app_quiz_assessment.databinding.ActivityQuestionsBinding
import br.edu.infnet.app_quiz_assessment.models.QuestionsAndOptions

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionsBinding

    var counterLife = 3

    private var currentPosition: Int = 1
    private var questionsList: ArrayList<QuestionsAndOptions>? = null
    private var correctAnswers: Int = 0
    private var selectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    @SuppressLint("SetTextI18n")
    private fun setup() {
        binding.tvTotalLife.text = "0$counterLife"

        questionsList = Constants.getQuestions()

        // Adiciona um evento de clique para o botão de envio
        binding.nextBtn.setOnClickListener(this)

        setQuestion()
        configureButtons()
    }
    override fun onClick(checker: View?) {

        when (checker?.id) {

            R.id.tv_option1 -> {
                selectedOptionView(binding.tvOption1, 1)
                checkAnswer()
            }

            R.id.tv_option2 -> {
                selectedOptionView(binding.tvOption2, 2)
                checkAnswer()
            }

            R.id.tv_option3 -> {
                selectedOptionView(binding.tvOption3, 3)
                checkAnswer()
            }

            R.id.tv_option4 -> {
                selectedOptionView(binding.tvOption4, 4)
                checkAnswer()
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun checkAnswer() {
        val question = questionsList?.get(currentPosition - 1)


        // Verifica se a resposta está errada
        if (question!!.correctAnswer != selectedOptionPosition) {
            answerView(selectedOptionPosition, R.drawable.wrong_option)

            //Diminui uma vida no contador e volta para tela inicial quando a vida chegar a 0
            counterLife--
            binding.tvTotalLife.text = "0$counterLife"
            if (counterLife == 0){
                val intent = Intent(this, TryAgainActivity::class.java)
                startActivity(intent)
            }
        } else {
            correctAnswers++
        }

        // Verifica se a resposta está correta
        answerView(question.correctAnswer, R.drawable.correct_option)
        selectedOptionPosition = 0
    }

    private fun backToInitialActivity() {
        val intent = Intent(this, InitialActivity::class.java)
        startActivity(intent)
    }

    private fun configureButtons() {

        binding.tvOption1.setOnClickListener(this)
        binding.tvOption2.setOnClickListener(this)
        binding.tvOption3.setOnClickListener(this)
        binding.tvOption4.setOnClickListener(this)

        // Avança para a próxima questão
        binding.nextBtn.setOnClickListener {
            if (selectedOptionPosition == 0) {
                currentPosition++
                when {
                    currentPosition <= questionsList!!.size -> { setQuestion() }
                    else -> {
                        backToInitialActivity()
                    }
                }
            }
        }

        // Volta para a tela inicial
        binding.closeBtn.setOnClickListener {
            backToInitialActivity()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val question =
            // Pega a pergunta da lista de acordo com a posição atual
            questionsList!![currentPosition - 1]

        defaultOptionsView()

        // Contador de questões
        binding.tvTotalQuestions.text = "$currentPosition" + "/" + "${questionsList!!.lastIndex+1}"
        binding.tvCounter.text = "$currentPosition. "

        binding.questionContainer2.text = question.pergunta
        binding.tvOption1.text = question.option1
        binding.tvOption2.text = question.option2
        binding.tvOption3.text = question.option3
        binding.tvOption4.text = question.option4
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        selectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.shape_teste_botao
        )
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOption1)
        options.add(1, binding.tvOption2)
        options.add(2, binding.tvOption3)
        options.add(3, binding.tvOption4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.shape_teste_botao
            )
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                binding.tvOption1.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                binding.tvOption2.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                binding.tvOption3.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                binding.tvOption4.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}