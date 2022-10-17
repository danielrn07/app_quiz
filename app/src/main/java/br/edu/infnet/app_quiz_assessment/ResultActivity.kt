package br.edu.infnet.app_quiz_assessment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.app_quiz_assessment.databinding.ActivityInitialBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityResultBinding
import br.edu.infnet.app_quiz_assessment.utils.getLoginFromSharedPrefs

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
        binding.tvName.text = "Parabéns ${getLoginFromSharedPrefs()}"

        configureButtons()

        val resultado = intent.getStringExtra(QuestionsActivity.RESULTADO) ?: ""
        binding.tvResult.text = "Você acertou $resultado questões!"
    }

    private fun configureButtons() {
        binding.btnHome.setOnClickListener {
            val intent = Intent(this, InitialActivity::class.java)
            startActivity(intent)
        }
    }
}


