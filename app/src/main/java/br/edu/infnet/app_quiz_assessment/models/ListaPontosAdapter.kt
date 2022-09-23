package br.edu.infnet.app_quiz_assessment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.app_quiz_assessment.databinding.FragmentQuestion1Binding
import br.edu.infnet.app_quiz_assessment.databinding.QuestionItemListBinding
import br.edu.infnet.app_quiz_assessment.models.Question

class QuestionAdapter: ListAdapter<Question, QuestionAdapter.ViewHolder>(QuestionDiffCallBack()) {

    private var questionsListTest: ArrayList<Question>? = null


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
        fun bind(item: Question) {
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

class QuestionDiffCallBack: DiffUtil.ItemCallback<Question>() {

    override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem.question == newItem.question
    }

    override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem == newItem
    }
}
