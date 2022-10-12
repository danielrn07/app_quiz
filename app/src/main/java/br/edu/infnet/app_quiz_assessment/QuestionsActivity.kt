package br.edu.infnet.app_quiz_assessment

import android.annotation.SuppressLint
import android.app.PendingIntent.CanceledException
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import br.edu.infnet.app_quiz_assessment.MainActivity.Companion.NOME
import br.edu.infnet.app_quiz_assessment.databinding.ActivityQuestionsBinding
import br.edu.infnet.app_quiz_assessment.models.Constants
import br.edu.infnet.app_quiz_assessment.models.MainViewModel
import br.edu.infnet.app_quiz_assessment.models.QuestionsAndOptions
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuestionsBinding

    val viewModel: MainViewModel by viewModels()

    var counterLife = 3
    var resultado = 0
    var respondido = false

    private var currentPosition: Int = 1
    private var questionsList: ArrayList<QuestionsAndOptions>? = null
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
        binding.tvTotalLife.text = " 0$counterLife"
        questionsList = Constants.getQuestions()

        configureButtons()
        setupObservers()
        setQuestion()
        onClickNextQuestion()

    }

    @SuppressLint("SetTextI18n")
    private fun setupObservers() {
        viewModel.isCheck.observe(this) {
            if (it == true) {

                val question = questionsList?.get(currentPosition - 1)

                // Verifica se a resposta está errada
                if (question!!.correctAnswer != selectedOptionPosition) {
                    answerView(selectedOptionPosition, R.drawable.wrong_option)

                    //Diminui uma vida no contador e volta para tela inicial quando a vida chegar a 0
//                    counterLife--
//                    binding.tvTotalLife.text = " 0$counterLife"
//                    if (counterLife <= 0) {
//                        val intent = Intent(this, TryAgainActivity::class.java)
//                        startActivity(intent)
//                    }
                } else {
                    resultado += 1
                }

                // Verifica se a resposta está correta
                answerView(question.correctAnswer, R.drawable.correct_option)
                selectedOptionPosition = 0
                respondido = true
            }
        }
    }

    fun pulaQuestao() {
        finalizarCronometro()
        if (selectedOptionPosition != -1) {
            currentPosition++
            when {
                currentPosition <= questionsList!!.size -> {
                    setQuestion()

                }
                else -> {
                    val nome = intent.getStringExtra(NOME) ?: ""
                    val intent =
                        Intent(this@QuestionsActivity, ResultActivity::class.java).apply {
                            putExtra(NOME, nome)
                            putExtra(RESULTADO, resultado.toString())
                        }
                    startActivity(intent)
                }
            }
            respondido = false
        }
    }

    private fun backToInitialActivity() {
        val intent = Intent(this, InitialActivity::class.java)
        startActivity(intent)
    }

    private fun configureButtons() {
        with(binding) {
            tvOption1.setOnClickListener(this@QuestionsActivity)
            tvOption2.setOnClickListener(this@QuestionsActivity)
            tvOption3.setOnClickListener(this@QuestionsActivity)
            tvOption4.setOnClickListener(this@QuestionsActivity)

            // Volta para a tela inicial
            closeBtn.setOnClickListener {
                backToInitialActivity()
            }
        }
    }

    fun onClickNextQuestion() {
        binding.nextBtn.setOnClickListener {
            if (respondido) {
                pulaQuestao()
            }
        }
    }

    override fun onClick(checker: View?) {

        if (respondido.not()) {
            when (checker?.id) {
                R.id.tv_option1 -> {
                    selectedOptionView(binding.tvOption1, 1)
                    viewModel.setIsCheck(true)
                }

                R.id.tv_option2 -> {
                    selectedOptionView(binding.tvOption2, 2)
                    viewModel.setIsCheck(true)
                }

                R.id.tv_option3 -> {
                    selectedOptionView(binding.tvOption3, 3)
                    viewModel.setIsCheck(true)
                }

                R.id.tv_option4 -> {
                    selectedOptionView(binding.tvOption4, 4)
                    viewModel.setIsCheck(true)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        iniciarCronometro()
        with(binding) {
            val question =
                // Pega a pergunta da lista de acordo com a posição atual
                questionsList!![currentPosition - 1]

            defaultOptionsView()

            // Contador de questões
            //tvTotalQuestions.text = "$currentPosition" + "/" + "${questionsList!!.lastIndex + 1}"
            tvTotalQuestions.text = "$currentPosition. "

            questionContainer2.text = question.pergunta
            tvOption1.text = question.option1
            tvOption2.text = question.option2
            tvOption3.text = question.option3
            tvOption4.text = question.option4
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        selectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#dce0dd")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.shape_options
        )
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOption1)
        options.add(1, binding.tvOption2)
        options.add(2, binding.tvOption3)
        options.add(3, binding.tvOption4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.shape_options
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

    var job: CoroutineContext? = null


    fun iniciarCronometro() {
//        setupObservers()
        var tempo = 15
        job = lifecycleScope.launch() {
            try {
                withTimeout(16000) {

                    while (true) {
                        delay(1000)
                        tempo--
                        binding.tvCount?.text = tempo.toString()
                    }
                }
            } catch (e: Exception) {
                if (tempo <= 1) {
                    pulaQuestao()
                }
            }
        }
        binding.tvCount?.text = "15"
    }

    fun finalizarCronometro() {
        if (job?.isActive == true) {
            job!!.cancel(CancellationException("Cancelled by user"))
            job = null
        }
    }

    companion object {
        val RESULTADO = "RESULTADO"
    }
}