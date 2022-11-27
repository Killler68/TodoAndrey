package com.example.myapplication.notes.noteadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.databinding.FragmentNotesAddBinding
import com.example.myapplication.notes.common.model.NotesData
import com.example.myapplication.notes.noteadd.viewmodel.NoteAddViewModel


class FragmentNoteAdd : DialogFragment() {

    private var _binding: FragmentNotesAddBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteAddViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentNotesAddBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createNote()
        setupObservables()
        setupListeners()

    }

    private fun createNote() {
        binding.buttonAdd.setOnClickListener {
            val note = NotesData(
                title = binding.editNoteTitle.text.toString(),
                description = binding.editNoteDescription.text.toString(),
            )
            viewModel.createNotesData(note)
            viewModel.navigateToNotes()
        }
    }

    private fun setupObservables() {
        viewModel.navCommand.observe(viewLifecycleOwner, ::onDataLoadedNavigate)
    }

    private fun onDataLoadedNavigate(navCommand: NavCommand) =
        findNavController().navigate(navCommand.action, navCommand.command)

    private fun setupListeners() {
        binding.buttonBack.setOnClickListener {
            viewModel.navigateToNotes()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}