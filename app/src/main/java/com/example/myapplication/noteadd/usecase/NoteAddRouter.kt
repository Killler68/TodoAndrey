package com.example.myapplication.noteadd.usecase

import com.example.myapplication.common.navigation.NavCommand

interface NoteAddRouter {

    fun toNotes(): NavCommand
}