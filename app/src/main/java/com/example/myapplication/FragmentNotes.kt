package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.fragment.navigateToFragment
import com.example.myapplication.databinding.FragmentRecyclerBinding
import com.example.myapplication.item.NotesItem
import com.example.myapplication.viewmodel.NotesViewModel
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
        addingNoteAndDeleting()
        viewModel.loadNoteData()
        navigateCreateNote()
    }

    private fun addingNoteAndDeleting() {
        viewModel.model.observe(viewLifecycleOwner) { it ->
            FastAdapterDiffUtil[notesItemAdapter] =
                it.map {
                    NotesItem(
                        it,
                        viewModel::deleteNoteData
                    )
                }
        }
    }

    private fun navigateCreateNote() {
        binding.addNotes.setOnClickListener {
            navigateToFragment(FragmentNotesAdd())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}