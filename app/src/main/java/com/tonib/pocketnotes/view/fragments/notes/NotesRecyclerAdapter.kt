package com.tonib.pocketnotes.view.fragments.notes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tonib.pocketnotes.databinding.ItemNoteBinding

class NotesRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<NotesRecyclerAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemBinding =
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val name: String = names[position]
        holder.bind(name)
    }

    class NoteViewHolder(private val noteBinding: ItemNoteBinding) :
        RecyclerView.ViewHolder(noteBinding.root) {
        fun bind(note: String) {
            noteBinding.tvTitle.text = note
        }
    }

    override fun getItemCount() = names.size

}