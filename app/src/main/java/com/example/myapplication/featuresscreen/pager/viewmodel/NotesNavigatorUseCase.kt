package com.example.myapplication.featuresscreen.pager.viewmodel

interface NotesNavigatorUseCase {

   suspend operator fun invoke(userId: Int)
}