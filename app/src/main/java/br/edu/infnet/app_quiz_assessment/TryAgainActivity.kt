package br.edu.infnet.app_quiz_assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.app_quiz_assessment.databinding.ActivityQuestionsBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityTryAgainBinding

class TryAgainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTryAgainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTryAgainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    private fun setup() {
        configuraBotoes()
    }

    private fun configuraBotoes() {
        // Reinicia as questões
        binding.btnYes.setOnClickListener {
            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)
        }

        // Volta para a tela inicial
        binding.btnNot.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}