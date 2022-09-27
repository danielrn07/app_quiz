package br.edu.infnet.app_quiz_assessment.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.app_quiz_assessment.databinding.QuestionItemListBinding

class RankListAdapter: ListAdapter<RankList, RankListAdapter.ViewHolder>(QuestionDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class ViewHolder private constructor(
        val binding: QuestionItemListBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RankList) {
            binding.tvOptions.text = item.name
            binding.tvPoints.text = item.pontos.toString()


        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = QuestionItemListBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding)
            }
        }
    }
}

class QuestionDiffCallBack: DiffUtil.ItemCallback<RankList>() {

    override fun areItemsTheSame(oldItem: RankList, newItem: RankList): Boolean {
        return oldItem.name == newItem.name
    }


    override fun areContentsTheSame(oldItem: RankList, newItem: RankList): Boolean {
        return oldItem == newItem
    }
}
