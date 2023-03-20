package com.example.myapplication.user.pager.viewmodel

interface NotesNavigatorUseCase {

   suspend operator fun invoke(userId: Int)
}