package com.example.myapplication.notes.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.common.flow.launchWhenViewCreated
import com.example.myapplication.common.fragment.getViewModelFactory
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.string.FEATURES_ID_KEY
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentNotesBinding
import com.example.myapplication.notes.note.viewholder.NotesItem
import com.example.myapplication.notes.note.viewmodel.NotesViewModel
import com.example.myapplication.notes.noteadd.NoteAddFragment
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
        viewModel.loadNotes(userId)
        viewModel.loadUser(userId)
    }

    private fun setupObservables() {
        launchWhenViewCreated {
            with(viewModel) {
                user.observe(::onDataLoadedUser)
                notes.observe(::onDataLoadedNote)
            }
        }
    }

    private fun onDataLoadedNote(notesData: List<NotesItem>) {
        FastAdapterDiffUtil[notesItemAdapter] = notesData
    }

    private fun onDataLoadedUser(user: User) {
        binding.nameUser.text = user.name
    }

    private fun setupListeners() {
        binding.addNotes.setOnClickListener {
            viewModel.navigateToNoteAdd(userId)
        }
        binding.imageUser.setOnClickListener {
            viewModel.navigateToUser()
        }
    }

    private fun setupFastAdapter() {
        with(binding.recyclerAddNote) {
            adapter = fastAdapter
            itemAnimator = null
        }
    }

    companion object {
        fun newInstance(userId: Int): NotesFragment {
            val fragment = NotesFragment()
            fragment.arguments = bundleOf(
                USER_ID_KEY to userId,
//                FEATURES_ID_KEY to featureId
            )
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}