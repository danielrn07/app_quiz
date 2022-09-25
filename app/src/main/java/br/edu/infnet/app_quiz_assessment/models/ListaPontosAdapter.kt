package br.edu.infnet.app_quiz_assessment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.app_quiz_assessment.databinding.FragmentQuestion1Binding
import br.edu.infnet.app_quiz_assessment.databinding.QuestionItemListBinding
import br.edu.infnet.app_quiz_assessment.models.Option

class QuestionAdapter: ListAdapter<Option, QuestionAdapter.ViewHolder>(QuestionDiffCallBack()) {

    private var questionsListTest: ArrayList<Option>? = null


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
        fun bind(item: Option) {
            binding.tvOptionOne.text = item.question


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

class QuestionDiffCallBack: DiffUtil.ItemCallback<Option>() {

    override fun areItemsTheSame(oldItem: Option, newItem: Option): Boolean {
        return oldItem.question == newItem.question
    }

    override fun areContentsTheSame(oldItem: Option, newItem: Option): Boolean {
        return oldItem == newItem
    }
}
