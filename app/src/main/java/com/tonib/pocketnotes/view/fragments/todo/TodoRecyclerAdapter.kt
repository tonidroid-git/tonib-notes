package com.tonib.pocketnotes.view.fragments.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tonib.pocketnotes.databinding.ItemNoteBinding
import com.tonib.pocketnotes.databinding.ItemTodoBinding
import com.tonib.pocketnotes.view.fragments.notes.NotesRecyclerAdapter

class TodoRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<TodoRecyclerAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemBinding =
            ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val name: String = names[position]
        holder.bind(name)
    }

    class TodoViewHolder(private val noteBinding: ItemTodoBinding) :
        RecyclerView.ViewHolder(noteBinding.root) {
        fun bind(note: String) {
            noteBinding.tvTitle.text = note
        }
    }

    override fun getItemCount() = names.size

}