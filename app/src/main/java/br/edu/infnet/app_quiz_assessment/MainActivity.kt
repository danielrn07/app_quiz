package br.edu.infnet.app_quiz_assessment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.models.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    private fun setup() {
        setupObservers()
        configureButtons()
    }


    private fun setupObservers() {
        viewModel.isCheck.observe(this) {
            if (it == true) {
                Toast.makeText(
                    this, "Por favor, insira seu nome!", Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    private fun configureButtons() {
        binding.btnAvancar.setOnClickListener {
            if (binding.inputName.text.toString().isEmpty()) {
                viewModel.setIsCheck(true)
            } else {
                val intent = Intent(this, InitialActivity::class.java).apply {
                    val nome = binding.inputName.text.toString()
                    putExtra(NOME, nome)
                }
                startActivity(intent)
            }
        }
    }

    companion object {
        val NOME = "NOME"
    }
}

