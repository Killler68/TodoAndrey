package com.example.myapplication.notes.note.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.common.database.note.models.NoteData
import com.example.myapplication.databinding.RecyclerItemNoteBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class NotesItem(
    private val notes: NoteData,
    private val onClickDelete: (Int) -> Unit
) : AbstractBindingItem<RecyclerItemNoteBinding>() {

    override fun bindView(binding: RecyclerItemNoteBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.title.text = notes.title
        binding.description.text = notes.description
        binding.removeNotes.setOnClickListener {
            onClickDelete(notes.id)
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemNoteBinding =
        RecyclerItemNoteBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_card_view
}