package id.gits.library.presenter.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.gits.library.R
import id.gits.library.databinding.ItemExampleBinding
import id.gits.library.domain.model.Example

class ExampleAdapter : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    private val examples = ArrayList<Example>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(examples[position], position)
    }

    override fun getItemCount(): Int {
        return examples.size
    }

    fun setExamples(documentations: List<Example>?) {
        documentations?.apply {
            this@ExampleAdapter.examples.clear()
            this@ExampleAdapter.examples.addAll(this)
        }

        notifyItemRangeChanged(0, examples.size)
    }

    inner class ViewHolder(
        private val binding: ItemExampleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(example: Example, position: Int) {
            binding.tvExampleIndex.text =
                binding.root.context.getString(R.string.format_example_index, position + 1)
            binding.tvCode.text = example.code
            binding.tvResult.text = example.result
        }
    }
}