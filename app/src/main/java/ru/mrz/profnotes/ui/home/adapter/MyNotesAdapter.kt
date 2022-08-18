package ru.mrz.profnotes.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mrz.profnotes.data.model.LocalNote
import ru.mrz.profnotes.databinding.ItemNoteBinding

class MyNotesAdapter : RecyclerView.Adapter<MyNotesAdapter.ViewHolder>() {
    private var items = emptyList<LocalNote>()

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: LocalNote){
                with(binding) {
                    tvNoteTitle.text = item.title
                    tvNoteDescription.text = item.description
                    tvNoteStatus.text = item.status
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemNoteBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<LocalNote>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size
}