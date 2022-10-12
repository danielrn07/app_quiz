package br.edu.infnet.app_quiz_assessment.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.app_quiz_assessment.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)

        setup()
        return binding.root
    }

    private fun setup() {
        configureButtons()
    }

    private fun configureButtons() {
        // Implementa cliques dos botões no dialog
        binding.btnLinkedin.setOnClickListener { showLinkedIn() }
        binding.btnGithub.setOnClickListener { showGithub() }
    }

//    @SuppressLint("QueryPermissionsNeeded")
//    private fun showLinkedIn() {
//        val sendIntent = Intent(Intent.ACTION_VIEW)
//        val title:Uri = Uri.parse("https://www.linkedin.com/in/danielrn07/")
//        val chooser: Intent = Intent.createChooser(sendIntent, title.toString())
//
//        if (sendIntent.resolveActivity(requireActivity().packageManager) != null) {
//            startActivity(chooser)
//        }
//    }


//    private fun showLinkedIn() {
//        try {
//            val uri = Uri.parse("https://www.linkedin.com/in/danielrn07/")
//            startActivity(Intent(Intent.ACTION_VIEW, uri))
//        } catch (e: Error) {
//        }
//    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun showLinkedIn() {
        val sendIntent = Intent().apply {
            val uri = Uri.parse("https://www.linkedin.com/in/danielrn07/")
            action = Intent.ACTION_VIEW
        }
        if (sendIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(sendIntent)
        }
    }


    private fun showGithub() {
        try {
            val uri = Uri.parse("https://github.com/danielrn07")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        } catch (e: Error) {
        }
    }
}