package br.edu.infnet.app_quiz_assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityTesteBinding
import br.edu.infnet.app_quiz_assessment.models.Option

//class TesteActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityTesteBinding
//
//    val listaPontos: MutableList<Option> by lazy {
//        mutableListOf<Option>()
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityTesteBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        configuraBotão()
//        setup()
//    }
//
//    var cont = 0
//
//    private fun configuraBotão() {
//        binding.nextBtn.setOnClickListener {
//            cont = cont++
//        }
//    }
//
//    private fun setup() {
//        setupRecyclerView()
//    }
//
//    private fun setupRecyclerView() {
//        setupInitialList()
//
//        val adapter = QuestionAdapter()
//        binding.rvAnswers.adapter = adapter
//
//        binding.rvAnswers.layoutManager = LinearLayoutManager(
//            this,
//            LinearLayoutManager.VERTICAL,
//            false
//        )
//        var questionList = listOf(
//            QuestionAnswer("Isso é um teste?", listOf(Option("sim"), Option("não"))),
//            QuestionAnswer("Pergunta 2", listOf(Option("teste1teste"), Option("teste2")))
//        )
//        binding.questionContainer2.text = questionList[cont].pergunta
//        adapter.submitList(questionList[cont].resposta)
//
//    }
//
//    private fun setupInitialList() {
//        listaPontos.add(Option("Option1"))
//        listaPontos.add(Option("Option2"))
//        listaPontos.add(Option("Option3"))
//        listaPontos.add(Option("Option4"))
//    }
//
//}