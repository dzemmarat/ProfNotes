package ru.mrz.profnotes.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mrz.profnotes.data.model.NewNote
import ru.mrz.profnotes.databinding.ItemNewNoteBinding

class NewNotesAdapter : RecyclerView.Adapter<NewNotesAdapter.ViewHolder>() {
    private var items = emptyList<NewNote>()

    inner class ViewHolder(private val binding: ItemNewNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: NewNote){
                with(binding) {
                    tvTitle.text = item.title
                    tvDescription.text = item.description
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemNewNoteBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<NewNote>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}