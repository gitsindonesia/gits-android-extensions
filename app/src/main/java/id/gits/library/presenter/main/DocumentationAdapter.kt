package id.gits.library.presenter.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.gits.library.databinding.ItemDocumentationBinding
import id.gits.library.R
import id.gits.library.domain.model.Documentation

class DocumentationAdapter : RecyclerView.Adapter<DocumentationAdapter.ViewHolder>() {

    private val documentations = ArrayList<Documentation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDocumentationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(documentations[position], position)
    }

    override fun getItemCount(): Int {
        return documentations.size
    }

    fun setDocumentations(documentations: List<Documentation>?) {
        documentations?.apply {
            this@DocumentationAdapter.documentations.clear()
            this@DocumentationAdapter.documentations.addAll(this)
        }

        notifyItemRangeChanged(0, this.documentations.size)
    }

    inner class ViewHolder(
        private val binding: ItemDocumentationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(documentation: Documentation, position: Int) {
            binding.btnExtension.text = binding.root.context.getString(
                R.string.format_list_item,
                position + 1,
                documentation.extensionName
            )
            binding.rvExample.adapter = ExampleAdapter().apply {
                setExamples(documentation.examples)
            }
        }
    }
}