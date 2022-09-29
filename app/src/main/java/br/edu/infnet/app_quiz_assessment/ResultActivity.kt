package br.edu.infnet.app_quiz_assessment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.app_quiz_assessment.MainActivity.Companion.NOME
import br.edu.infnet.app_quiz_assessment.databinding.ActivityInitialBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    @SuppressLint("SetTextI18n")
    private fun setup() {
        configureButtons()

        val resultado = intent.getStringExtra(QuestionsActivity.RESULTADO) ?: ""
        val nome = intent.getStringExtra(NOME) ?: ""

        binding.tvResult.text = "Você acertou $resultado questões!"
        binding.tvName.text = "Parabéns $nome!"
    }

    private fun configureButtons() {
        binding.btnHome.setOnClickListener {
            val intent = Intent(this, InitialActivity::class.java)
            startActivity(intent)
        }
    }
}


