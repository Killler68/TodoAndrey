package com.example.myapplication.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.databinding.FragmentRecyclerBinding
import com.example.myapplication.model.NotesData
import com.example.myapplication.notes.viewholder.NotesItem
import com.example.myapplication.notes.viewmodel.NotesViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class FragmentNotes : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    private val notesItemAdapter = ItemAdapter<NotesItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(notesItemAdapter))

    private val viewModel: NotesViewModel by viewModels { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentRecyclerBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recycler) {
            adapter = fastAdapter
            itemAnimator = null
        }
        setupObservables()
        setupListeners()
        viewModel.loadNoteData()
    }

    private fun setupObservables() {
        viewModel.model.observe(viewLifecycleOwner, ::onDataLoadedNote)
        viewModel.navCommand.observe(viewLifecycleOwner, ::onDataLoadedNavigate)
    }

    private fun onDataLoadedNote(notesData: List<NotesData>) {
        FastAdapterDiffUtil[notesItemAdapter] =
            notesData.map {
                NotesItem(
                    it,
                    viewModel::deleteNoteData
                )
            }
    }

    private fun onDataLoadedNavigate(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun setupListeners() {
        binding.addNotes.setOnClickListener {
            viewModel.navigateToNotesAdd()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}