package br.edu.infnet.app_quiz_assessment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import br.edu.infnet.app_quiz_assessment.MainActivity.Companion.NOME
import br.edu.infnet.app_quiz_assessment.databinding.ActivityInitialBinding
import br.edu.infnet.app_quiz_assessment.databinding.ActivityMainBinding
import br.edu.infnet.app_quiz_assessment.databinding.CustomBottomSheetBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog

class InitialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInitialBinding

    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitialBinding.inflate(layoutInflater)
        val view = binding.root


        setup()
        setContentView(view)
    }


    private fun setup() {
        // Inicia Activity Questions
        val intent = Intent(this, QuestionsActivity::class.java).apply {
            val nome = intent.getStringExtra(NOME) ?: ""
            putExtra(NOME, nome)
        }


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.navView, navController)

        configureButtons()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun configureButtons() {


//            btnSobre.setOnClickListener {
//                showBottomSheetDialog()
//            }
//
//            btnRank.setOnClickListener {
//                val intent = Intent(this@InitialActivity, RankActivity::class.java)
//                startActivity(intent)
//            }
    }
}

//    private fun showBottomSheetDialog() {
//        val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog)
//        val sheetBinding: CustomBottomSheetBinding =
//            CustomBottomSheetBinding.inflate(layoutInflater, null, false)
//
//        // Implementa cliques dos botões no dialog
//        sheetBinding.btnLinkedin.setOnClickListener { showLinkedIn() }
//        sheetBinding.btnGithub.setOnClickListener { showGithub() }
//
//        dialog.setContentView(sheetBinding.root)
//        dialog.show()
//    }
//
//    private fun showLinkedIn() {
//        val uri = Uri.parse("https://www.linkedin.com/in/danielrn07/")
//        startActivity(Intent(Intent.ACTION_VIEW, uri))
//    }
//
//    private fun showGithub() {
//        val uri = Uri.parse("https://github.com/danielrn07")
//        startActivity(Intent(Intent.ACTION_VIEW, uri))
//    }
