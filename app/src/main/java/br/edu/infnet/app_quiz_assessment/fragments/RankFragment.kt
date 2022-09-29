package br.edu.infnet.app_quiz_assessment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.app_quiz_assessment.databinding.FragmentRankBinding
import br.edu.infnet.app_quiz_assessment.models.RankList
import br.edu.infnet.app_quiz_assessment.models.RankListAdapter

class RankFragment : Fragment() {

    private var _binding: FragmentRankBinding? = null
    private val binding get() = _binding!!

    val listaPontos: MutableList<RankList> by lazy {
        mutableListOf<RankList>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRankBinding.inflate(inflater, container, false)

        setup()
        return binding.root
    }

    private fun setup() {
        setupRecyclerView()
    }

    val adapter = RankListAdapter()

    private fun setupRecyclerView() {
        setupInitialList()
        binding.rvTeste.adapter = adapter
        binding.rvTeste.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        atualizaRecyclerView()
    }

    private fun setupInitialList() {
        listaPontos.add(RankList("Daniel Nascimento", 10))
        listaPontos.add(RankList("Daniel", 9))
        listaPontos.add(RankList("Paulo", 8))
        listaPontos.add(RankList("PD", 7))
    }

    fun atualizaRecyclerView() {
        adapter.submitList(listaPontos)
        binding.rvTeste.adapter = adapter
    }
}