package com.example.myapplication.notes.note.viewmodel

interface UserNavigatorUseCase {

    operator fun invoke(userId: Int)
}