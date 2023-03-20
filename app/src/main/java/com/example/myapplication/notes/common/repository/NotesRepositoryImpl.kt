package com.example.myapplication.notes.common.repository

import com.example.myapplication.common.database.note.NoteDao
import com.example.myapplication.common.database.note.models.NoteData
import com.example.myapplication.common.database.note.tuples.CreateNoteTuple
import com.example.myapplication.common.database.note.tuples.DeleteNoteTuple
import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.common.model.toNote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class NotesRepositoryImpl(
    private val noteDao: NoteDao
) : NotesRepository {


    override suspend fun getNote(id: Int): NoteData =
        withContext(Dispatchers.IO) {
            val notes = noteDao.getNoteById(id) ?: throw Exception("Structure $id not found")
            Timber.i("requested note №$id: $notes")
            NoteData(
                id = id,
                userId = notes.userId,
                title = notes.title,
                description = notes.description
            )
//            notes ?: throw Exception("Notes $id not found")
        }

    override suspend fun getNotes(userId: Int): List<NoteData> =
        withContext(Dispatchers.IO) {
            val notes = noteDao.getNotes(userId)
            Timber.i("notes: №${notes?.toList()}")
            notes?.map {
                NoteData(
                    id = it.id,
                    userId = it.userId,
                    title = it.title,
                    description = it.description
                )
            } ?: throw Exception("Notes not found")
//            noteDao.getNotes(userId).map { it.toNote() }.toList()
        }

    override suspend fun addNotes(noteData: CreateNoteTuple): Notes =

        withContext(Dispatchers.IO) {
            noteDao.createNote(
                CreateNoteTuple(
                    userId = noteData.userId,
                    title = noteData.title,
                    description = noteData.description
                )
            )
            return@withContext noteDao.getNotes(noteData.userId)?.last<NoteData>()?.toNote()!!
//            Timber.i("Created note: $createdNote")

}

//        }

    override suspend fun deleteNote(id: Int) =
        withContext(Dispatchers.IO) {
            Timber.i("note №$id deleted")
            noteDao.deleteNote(DeleteNoteTuple(id))
        }

}