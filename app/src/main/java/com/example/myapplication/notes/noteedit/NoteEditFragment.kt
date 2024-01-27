package com.example.myapplication.notes.noteedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.myapplication.common.string.NOTE_ID_KEY
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.databinding.FragmentNoteEditBinding


class NoteEditFragment : Fragment() {

    private var _binding: FragmentNoteEditBinding? = null
    private val binding get() = _binding!!


    private val userId by lazy {
        requireArguments().getInt(USER_ID_KEY)
    }

    private val noteId by lazy {
        requireArguments().getInt(NOTE_ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentNoteEditBinding.inflate(inflater, container, false)
        .also { _binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        fun newInstance(userId: Int, noteId: Int): NoteEditFragment {
            val fragment = NoteEditFragment()
            fragment.arguments = bundleOf(USER_ID_KEY to userId, NOTE_ID_KEY to noteId)
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}