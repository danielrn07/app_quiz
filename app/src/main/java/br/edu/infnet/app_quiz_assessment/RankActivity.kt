package br.edu.infnet.app_quiz_assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityRankBinding

class RankActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}