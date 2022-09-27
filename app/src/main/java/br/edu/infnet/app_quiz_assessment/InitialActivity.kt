package br.edu.infnet.app_quiz_assessment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
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
        var nome = intent.getStringExtra(MainActivity.NOME) ?: ""
        intent.putExtra(MainActivity.NOME, nome)

        configureButtons()
    }

    private fun configureButtons() {
        with(binding) {
            btnIniciar.setOnClickListener {
                val intent = Intent(this@InitialActivity, QuestionsActivity::class.java)
                startActivity(intent)
            }
            btnSobre.setOnClickListener {
                showBottomSheetDialog()
            }

            btnRank.setOnClickListener {
                val intent = Intent(this@InitialActivity, RankActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun showBottomSheetDialog() {
        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog)
        val sheetBinding: CustomBottomSheetBinding =
            CustomBottomSheetBinding.inflate(layoutInflater, null, false)

        // Implementa cliques nos botões no dialog
        sheetBinding.btnLinkedin.setOnClickListener { showLinkedIn() }
        sheetBinding.btnGithub.setOnClickListener { showGithub() }

        dialog.setContentView(sheetBinding.root)
        dialog.show()
    }


    private fun showLinkedIn() {
        val uri = Uri.parse("https://www.linkedin.com/in/danielrn07/")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    private fun showGithub() {
        val uri = Uri.parse("https://github.com/danielrn07")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

}