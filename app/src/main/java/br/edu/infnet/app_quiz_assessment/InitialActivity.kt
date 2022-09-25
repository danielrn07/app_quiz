package br.edu.infnet.app_quiz_assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.app_quiz_assessment.databinding.ActivityInitialBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.CustomBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class InitialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInitialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitialBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()

    }

    private fun setup() {
        configureButtons()
    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog)
        val sheetBinding: CustomBottomSheetBinding =
            CustomBottomSheetBinding.inflate(layoutInflater, null, false)
        dialog.setContentView(sheetBinding.root)
        dialog.show()
    }

    private fun configureButtons() {
        binding.btnIniciar.setOnClickListener {
            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)
        }
        binding.btnSobre.setOnClickListener {
            showBottomSheetDialog()
        }
    }
}