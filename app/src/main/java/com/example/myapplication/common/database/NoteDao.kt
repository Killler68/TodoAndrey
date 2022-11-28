package com.example.myapplication.common.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.common.database.models.NoteData
import com.example.myapplication.common.database.tuples.CreateNoteTuple
import com.example.myapplication.common.database.tuples.DeleteNoteTuple

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): Array<NoteData>

    @Query("SELECT * FROM notes WHERE id =:id")
    suspend fun getNoteById(id: Int): NoteData?

    @Insert(entity = NoteTable::class)
    suspend fun createNote(note: CreateNoteTuple): Long

    @Delete(entity = NoteTable::class)
    suspend fun deleteNote(note: DeleteNoteTuple)
}