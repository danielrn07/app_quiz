package br.edu.infnet.app_quiz_assessment

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        setup()
    }


    private fun setup() {
        configureButtons()
    }

    private fun configureButtons() {
        binding.btnAvancar.setOnClickListener {
            if (binding.inputName.text.toString().isEmpty()) {
                Toast.makeText(this, "Por favor, insira seu nome!", Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                val intent = Intent(this, InitialActivity::class.java)
                startActivity(intent)
            }
        }
    }
}