package br.edu.infnet.app_quiz_assessment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.app_quiz_assessment.databinding.FragmentQuestion1Binding
import br.edu.infnet.app_quiz_assessment.models.Option
import java.security.AccessControlContext
import java.security.AccessController.getContext


class Question1Fragment : Fragment() {

    private var _binding: FragmentQuestion1Binding? = null
    private val binding get() = _binding!!

    var cont = 0

    val listaPontos: MutableList<Option> by lazy {
        mutableListOf<Option>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuestion1Binding.inflate(inflater, container, false)
        val view = binding.root

        configuraBotao()
        teste()
        setup()



        return view

    }


    @SuppressLint("SetTextI18n")
    private fun teste() {
        binding.tvTotalQuestions.text = "${listaPontos.size}" + "/" + listaPontos.lastIndex
    }


//    private fun configuraBotao() {
//        binding.btnTeste.setOnClickListener {
//            if (cont == 0) {
//                cont++
//            }
//        }
//
//    }


    private fun setup() {
        setupRecyclerView()
    }

    val adapter = QuestionAdapter()

    private fun setupRecyclerView() {
        setupInitialList()
        binding.rvAnswers.adapter = adapter
        binding.rvAnswers.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        atualizaRecyclerView()
    }


    private fun setupInitialList() {
        listaPontos.add(Option("Option1"))
        listaPontos.add(Option("Option2"))
        listaPontos.add(Option("Option3"))
        listaPontos.add(Option("Option4"))
    }

    private fun configuraBotao() {
        binding.nextBtn.setOnClickListener {
            cont++

            atualizaRecyclerView()
        }
    }


    fun atualizaRecyclerView() {
        var questionList = listOf(
            QuestionAnswer(
                "De quem é a famosa frase “Penso, logo existo”?", listOf(
                    Option("Platão"),
                    Option("Galileu Galilei"),
                    Option("Descartes"),
                    Option("Sócrates"),
                    Option("Francis Bacon")
                )
            ),
            QuestionAnswer(
                "Pergunta 2", listOf(
                    Option("teste1"),
                    Option("teste2")
                )
            ),
            QuestionAnswer(
                "ad jfhvbsd 2", listOf(
                    Option("tesdfgfdte1"),
                    Option("tefgste2")
                )
            ),
            QuestionAnswer(
                "Paulo", listOf(
                    Option("Daniel"),
                    Option("tefgste2")
                )
            )
        )
        binding.questionContainer2.text = questionList[cont].pergunta
        adapter.submitList(questionList[cont].resposta)
        binding.questionCounter.text = "${cont.plus(1)}- "
    }


}


