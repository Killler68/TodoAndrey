package com.example.myapplication.noteadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.fragment.navigateToFragment
import com.example.myapplication.databinding.FragmentNotesAddBinding
import com.example.myapplication.model.NotesData
import com.example.myapplication.notes.FragmentNotes
import com.example.myapplication.noteadd.viewmodel.NotesAddViewModel


class FragmentNoteAdd : DialogFragment() {

    private var _binding: FragmentNotesAddBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NotesAddViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentNotesAddBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createNote()
        setupListeners()
    }

    private fun createNote() {
        binding.buttonAdd.setOnClickListener {
            val note = NotesData(
                title = binding.editNoteTitle.text.toString(),
                description = binding.editNoteDescription.text.toString(),
            )
            viewModel.createNotesData(note)
            onClickTransition()
        }
    }

    private fun setupListeners() {
        binding.buttonBack.setOnClickListener {
            onClickTransition()
        }
    }

    private fun onClickTransition() = navigateToFragment(FragmentNotes())

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}