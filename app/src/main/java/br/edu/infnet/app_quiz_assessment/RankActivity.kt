package br.edu.infnet.app_quiz_assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.app_quiz_assessment.databinding.ActivityRankBinding
import br.edu.infnet.app_quiz_assessment.models.RankList
import br.edu.infnet.app_quiz_assessment.models.RankListAdapter

class RankActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRankBinding

    val listaPontos: MutableList<RankList> by lazy {
        mutableListOf<RankList>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    private fun setup() {
        setupRecyclerView()
        configureButtons()
    }



    val adapter = RankListAdapter()

    private fun setupRecyclerView() {
        setupInitialList()
        binding.rvTeste.adapter = adapter
        binding.rvTeste.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        atualizaRecyclerView()
    }


    private fun setupInitialList() {
        listaPontos.add(RankList("Option1", 10))
        listaPontos.add(RankList("Option2", 9))
        listaPontos.add(RankList("Option3", 8))
        listaPontos.add(RankList("Option4", 7))
    }

    private fun configureButtons() {

        binding.btnMain.setOnClickListener {
            val intent = Intent(this, InitialActivity::class.java)
            startActivity(intent)
        }
        atualizaRecyclerView()
    }

    fun atualizaRecyclerView() {

        adapter.submitList(listaPontos)
        binding.rvTeste.adapter = adapter

//    var questionList = listOf(
//        RankList(
//            "De quem"
//        ),
//        RankList(
//            "Pergunta 2"
//        )
//    )
    }
}





