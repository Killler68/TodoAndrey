package com.example.myapplication.notes.common.repository

import com.example.myapplication.common.database.NoteDao
import com.example.myapplication.common.database.tuples.CreateNoteTuple
import com.example.myapplication.common.database.tuples.DeleteNoteTuple
import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.common.model.toNote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class NotesRepositoryImpl(
    private val noteDao: NoteDao
) : NotesRepository {


    override suspend fun getNote(id: Int): Notes =
        withContext(Dispatchers.IO) {
            val notes = noteDao.getNoteById(id)?.toNote()
            Timber.i("requested note №$id: $notes")
            notes ?: throw Exception("Notes $id not found")
        }

    override suspend fun getNotes(): List<Notes> =
        withContext(Dispatchers.IO) {
            val notes = noteDao.getNotes()
            Timber.i("notes: №${notes.toList()}")
            noteDao.getNotes().map { it.toNote() }.toList()
        }

    override suspend fun addNotes(noteData: Notes): Notes =
        withContext(Dispatchers.IO) {
            noteDao.createNote(
                CreateNoteTuple(
                    title = noteData.title,
                    description = noteData.description
                )
            )
            val createdNote = noteDao.getNotes().last().toNote()
            Timber.i("Created note: $createdNote")
            createdNote
        }

    override suspend fun deleteNote(id: Int) =
        withContext(Dispatchers.IO) {
            Timber.i("note №$id deleted")
            noteDao.deleteNote(DeleteNoteTuple(id))
        }

}