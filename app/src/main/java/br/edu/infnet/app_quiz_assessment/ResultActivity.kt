package br.edu.infnet.app_quiz_assessment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.app_quiz_assessment.databinding.ActivityInitialBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    @SuppressLint("SetTextI18n")
    private fun setup() {


        val resultado = intent.getStringExtra(QuestionsActivity.RESULTADO) ?: ""
        val nome = intent.getStringExtra(MainActivity.NOME) ?: "teste"

        binding.tvResult.text = "Você acertou $resultado questões!"
        binding.tvName.text = "Olá $nome"
    }

}


