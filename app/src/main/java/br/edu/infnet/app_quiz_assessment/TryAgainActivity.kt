package br.edu.infnet.app_quiz_assessment

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
    }
}