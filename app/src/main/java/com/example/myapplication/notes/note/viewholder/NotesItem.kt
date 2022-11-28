package com.example.myapplication.notes.note.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentItemBinding
import com.example.myapplication.notes.common.model.Notes
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class NotesItem(
    private val notes: Notes,
    private val onClickDelete: (Int) -> Unit,
//  private val onClickEditing: (NotesData) -> Unit
) : AbstractBindingItem<FragmentItemBinding>() {

    override fun bindView(binding: FragmentItemBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.textTitle.text = notes.title
        binding.textDescription.text = notes.description
        binding.removeNotes.setOnClickListener {
            onClickDelete(notes.id)
        }
//        binding.editingNotes.setOnClickListener {
//            onClickEditing(notesData)
//        }
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentItemBinding =
        FragmentItemBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_card_view
}