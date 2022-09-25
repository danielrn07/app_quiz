package br.edu.infnet.app_quiz_assessment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.Intent.EXTRA_INTENT
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import br.edu.infnet.app_quiz_assessment.databinding.FragmentQuestionsBinding



//class QuestionsFragment : Fragment(), View.OnClickListener {
//
//    private var _binding: FragmentQuestionsBinding? = null
//    private val binding get() = _binding!!
//
//
////    val listaPontos: MutableList<Option> by lazy {
////        mutableListOf<Option>()
////    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
//        val view = binding.root
//
//        binding.tvOption1.setOnClickListener(this)
//        binding.tvOption2.setOnClickListener(this)
//        binding.tvOption3.setOnClickListener(this)
//        binding.tvOption4.setOnClickListener(this)
//
//        binding.nextBtn.setOnClickListener(this)
//
////        configuraBotao()
////        teste()
//        setup()
//
//
//
//        return view
//
//    }
//
//    private fun setup() {
//        configuraBotao()
//        setQuestion()
//    }
//
//
//
//
//    private var currentPosition: Int = 1
//    private var questionsList: ArrayList<OptionTeste>? = null
//    private var correctAnswers: Int = 0
//    private var selectedOptionPosition: Int = 0
//
//
//
//
//    override fun onClick(v: View?) {
//
//        when (v?.id) {
//
//            R.id.tv_option1 -> {
//                selectedOptionView(binding.tvOption1, 1)
//                verificaResposta()
//            }
//
//            R.id.tv_option2 -> {
//                selectedOptionView(binding.tvOption2, 2)
//                verificaResposta()
//            }
//
//            R.id.tv_option3 -> {
//                selectedOptionView(binding.tvOption3, 3)
//                verificaResposta()
//            }
//
//            R.id.tv_option4 -> {
//                selectedOptionView(binding.tvOption4, 4)
//                verificaResposta()
//            }
//        }
//    }
//
//    private fun configuraBotao() {
//        binding.nextBtn.setOnClickListener {
//            if (selectedOptionPosition == 0) {
//                currentPosition++
//                when {
//                    currentPosition <= questionsList!!.size -> { setQuestion() }
//                    else -> {
//                        val intent = Intent(activity, MainActivity::class.java)
//                        startActivity(intent)
//                    }
//                }
//            }
//        }
//    }
//
//    fun verificaResposta() {
//        val question = questionsList?.get(currentPosition - 1)
//
//        // Verifica se a resposta está errada
//        if (question!!.correctAnswer != selectedOptionPosition) {
//            answerView(selectedOptionPosition, R.drawable.wrong_option)
//        } else {
//            correctAnswers++
//        }
//
//        // Verifica se a resposta está correta
//        answerView(question.correctAnswer, R.drawable.correct_option)
//        selectedOptionPosition = 0
//    }
//
//
//    private fun setQuestion() {
//        val question = questionsList!![currentPosition - 1] // Getting the question from the list with the help of current position.
//
//        defaultOptionsView()
//
//        binding.questionContainer2.text = question.pergunta
//        binding.tvOption1.text = question.option1
//        binding.tvOption2.text = question.option2
//        binding.tvOption3.text = question.option3
//        binding.tvOption4.text = question.option4
//    }
//
//    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
//
//        defaultOptionsView()
//
//        selectedOptionPosition = selectedOptionNum
//
//        tv.setTextColor(
//            Color.parseColor("#363A43")
//        )
//        tv.setTypeface(tv.typeface, Typeface.BOLD)
//        tv.background = ContextCompat.getDrawable(
//            requireContext(),
//            R.drawable.shape_teste_botao
//        )
//    }
//
//    private fun defaultOptionsView() {
//        val options = ArrayList<TextView>()
//        options.add(0, binding.tvOption1)
//        options.add(1, binding.tvOption2)
//        options.add(2, binding.tvOption3)
//        options.add(3, binding.tvOption4)
//
//        for (option in options) {
//            option.setTextColor(Color.parseColor("#7A8089"))
//            option.typeface = Typeface.DEFAULT
//            option.background = ContextCompat.getDrawable(
//                requireContext(),
//                R.drawable.shape_teste_botao
//            )
//        }
//    }
//
//
//
//    private fun answerView(answer: Int, drawableView: Int) {
//
//        when (answer) {
//
//            1 -> {
//                binding.tvOption1.background = ContextCompat.getDrawable(
//                    requireContext(),
//                    drawableView
//                )
//            }
//            2 -> {
//                binding.tvOption2.background = ContextCompat.getDrawable(
//                    requireContext(),
//                    drawableView
//                )
//            }
//            3 -> {
//                binding.tvOption3.background = ContextCompat.getDrawable(
//                    requireContext(),
//                    drawableView
//                )
//            }
//            4 -> {
//                binding.tvOption4.background = ContextCompat.getDrawable(
//                    requireContext(),
//                    drawableView
//                )
//            }
//        }
//    }
//
//}


