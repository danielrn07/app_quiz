package br.edu.infnet.app_quiz_assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.edu.infnet.app_quiz_assessment.databinding.ActivityInitialBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityQuestionsBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        setup()
    }

    companion object {
        val NOME = "NOME"
    }

    private fun setup() {
        configureButtons()
    }

    private fun configureButtons() {
        binding.btnAvancar.setOnClickListener {
            if (binding.inputName.text.toString().isEmpty()) {
                Toast.makeText(this, "Por favor, insira seu nome!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val nome = binding.inputName.text.toString()
                val intent = Intent(this, InitialActivity::class.java)
                intent.putExtra(NOME, nome)
                startActivity(intent)
            }
        }
    }
}