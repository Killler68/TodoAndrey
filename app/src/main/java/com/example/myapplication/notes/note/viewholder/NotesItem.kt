package com.example.myapplication.notes.note.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.RecyclerItemNoteBinding
import com.example.myapplication.notes.common.model.Notes
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import kotlin.reflect.KFunction2

class NotesItem(
    private val notes: Notes,
    private val onClickDelete: KFunction2<Int, Int, Unit>,
    private val onClickEdit: KFunction2<Int, Int, Unit>
) : AbstractBindingItem<RecyclerItemNoteBinding>() {

    override fun bindView(binding: RecyclerItemNoteBinding, payloads: List<Any>) {
        super.bindView(binding, payloads)

        binding.title.text = notes.title
        binding.description.text = notes.description
        binding.removeNotes.setOnClickListener {
            onClickDelete(notes.userId, notes.id)
        }
        binding.editingNotes.setOnClickListener {
            onClickEdit(notes.userId, notes.id)
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): RecyclerItemNoteBinding =
        RecyclerItemNoteBinding.inflate(inflater, parent, false)

    override val type: Int = R.id.background_card_view
}