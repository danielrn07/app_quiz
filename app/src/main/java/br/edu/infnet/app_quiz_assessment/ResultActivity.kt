package br.edu.infnet.app_quiz_assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}