package com.example.myapplication.notes.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentItemBinding
import com.example.myapplication.model.NotesData
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class NotesItem(
    private val notesData: NotesData,
    private val onClickDelete: (NotesData) -> Unit,
//  private val onClickEditing: (NotesData) -> Unit
) : AbstractBindingItem<FragmentItemBinding>() {

    override fun bindView(binding: FragmentItemBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.textTitle.text = notesData.title
        binding.textDescription.text = notesData.description
        binding.removeNotes.setOnClickListener {
            onClickDelete(notesData)
        }
//        binding.editingNotes.setOnClickListener {
//            onClickEditing(notesData)
//        }
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentItemBinding =
        FragmentItemBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_card_view
}