package br.edu.infnet.app_quiz_assessment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.app_quiz_assessment.databinding.FragmentQuestion1Binding
import br.edu.infnet.app_quiz_assessment.models.Question
import java.security.AccessControlContext
import java.security.AccessController.getContext


class Question1Fragment : Fragment() {

    private var _binding: FragmentQuestion1Binding? = null
    private val binding get() = _binding!!

    var cont = 0

    val listaPontos: MutableList<Question> by lazy {
        mutableListOf<Question>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuestion1Binding.inflate(inflater, container, false)
        val view = binding.root

//        configuraBotao()
        setup()



        return view

    }



//    private fun configuraBotao() {
//        binding.btnTeste.setOnClickListener {
//            if (cont == 0) {
//                cont++
//            }
//        }
//
//    }

//    private fun configuraBotao() {
//        binding.nextBtn.setOnClickListener {
//            contador()
//        }
//    }

//    private fun contador() {
//        cont = cont++
//    }


    private fun setup() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        setupInitialList()

        val adapter = QuestionAdapter()
        binding.rvAnswers.adapter = adapter

        binding.rvAnswers.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )


        var questionList = listOf(
            QuestionAnswer("Isso é um teste?", listOf(Question("sim"), Question("não"))),
            QuestionAnswer("Pergunta 2", listOf(Question("teste1"), Question("teste2")))
        )
        binding.questionContainer2.text = questionList[cont].pergunta
        adapter.submitList(questionList[cont].resposta)
    }


    private fun setupInitialList() {
        listaPontos.add(Question("Option1"))
        listaPontos.add(Question("Option2"))
        listaPontos.add(Question("Option3"))
        listaPontos.add(Question("Option4"))
    }


}


