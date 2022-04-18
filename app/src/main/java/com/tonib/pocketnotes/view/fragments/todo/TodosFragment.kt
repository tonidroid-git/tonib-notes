package com.tonib.pocketnotes.view.fragments.todo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonib.pocketnotes.R
import com.tonib.pocketnotes.databinding.FragmentNotesBinding
import com.tonib.pocketnotes.databinding.FragmentTodosBinding
import com.tonib.pocketnotes.view.fragments.notes.NotesRecyclerAdapter

class TodosFragment : Fragment() {

    private var _binding: FragmentTodosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodosBinding.inflate(inflater, container, false)

        binding.rvTodos.layoutManager = LinearLayoutManager(context)
        binding.rvTodos.adapter = NotesRecyclerAdapter(listOf("todo1", "todo2", "todo3"))

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun instance() = TodosFragment()
    }

}
