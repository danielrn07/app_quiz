package br.edu.infnet.app_quiz_assessment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.app_quiz_assessment.databinding.CustomBottomSheetBinding
import br.edu.infnet.app_quiz_assessment.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setup()
        return binding.root
    }

    private fun setup() {
        configureButtons()
    }

    private fun configureButtons() {

        with(binding) {
            btnIniciar.setOnClickListener {
                val intent = Intent(context, QuestionsActivity::class.java)
                startActivity(intent)
            }
        }




    }




}