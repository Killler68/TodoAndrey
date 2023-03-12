package com.example.myapplication.notes.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentNotesBinding
import com.example.myapplication.notes.note.viewholder.NotesItem
import com.example.myapplication.notes.note.viewmodel.NotesViewModel
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.diff.FastAdapterDiffUtil


class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    private val notesItemAdapter = ItemAdapter<NotesItem>()
    private val fastAdapter = GenericFastAdapter.with(listOf(notesItemAdapter))

    private val viewModel: NotesViewModel by viewModels { getViewModelFactory() }

    private val userId by lazy {
        requireArguments().getInt(USER_ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentNotesBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        setupListeners()
        setupFastAdapter()
        viewModel.loadNotes()
        viewModel.loadUser(userId)
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            with(viewModel) {
                user.observe(::onDataLoadedUser)
                notes.observe(::onDataLoadedNote)
                navCommand.observe(::onDataLoadedNavigate)
            }
        }
    }

    private fun onDataLoadedNote(notesData: List<NotesItem>) {
        FastAdapterDiffUtil[notesItemAdapter] = notesData
    }

    private fun onDataLoadedNavigate(navCommand: NavCommand) {
        findNavController().navigate(navCommand.action, navCommand.command)
    }

    private fun onDataLoadedUser(user: User) {
        binding.nameUser.text = user.name
    }

    private fun setupListeners() {
        binding.addNotes.setOnClickListener {
            viewModel.navigateToNotesAdd(userId)
        }
        binding.imageUser.setOnClickListener {
            viewModel.navigateToUser(userId)
        }
    }

    private fun setupFastAdapter() {
        with(binding.recyclerAddNote) {
            adapter = fastAdapter
            itemAnimator = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}