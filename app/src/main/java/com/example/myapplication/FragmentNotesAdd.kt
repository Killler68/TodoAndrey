package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.fragment.navigateToFragment
import com.example.myapplication.databinding.FragmentNotesAddBinding
import com.example.myapplication.model.NotesData
import com.example.myapplication.viewmodel.NotesAddViewModel


class FragmentNotesAdd : Fragment() {

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
        onClickBack()
    }

    private fun createNote() {
        binding.buttonAdd.setOnClickListener {
            val data = NotesData(
                title = binding.editNoteTitle.text.toString(),
                description = binding.editNoteDescription.text.toString(),
            )
            viewModel.createNotesData(data)
            onClickTransition()
        }
    }

    private fun onClickBack() {
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