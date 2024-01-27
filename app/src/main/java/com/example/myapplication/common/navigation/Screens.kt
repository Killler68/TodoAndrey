package com.example.myapplication.common.navigation

import com.example.myapplication.authorization.AuthorizationFragment
import com.example.myapplication.common.repository.User
import com.example.myapplication.featuresscreen.FeaturesScreenFragment
import com.example.myapplication.hotels.hoteldetailed.HotelDetailedFragment
import com.example.myapplication.hotels.hotellist.HotelListFragment
import com.example.myapplication.notes.note.NotesFragment
import com.example.myapplication.notes.noteadd.NoteAddFragment
import com.example.myapplication.notes.noteedit.NoteEditFragment
import com.example.myapplication.profile.ProfileFragment
import com.example.myapplication.registration.RegistrationFragment
import com.example.myapplication.settings.SettingsFragment
import com.example.myapplication.start.StartFragment
import com.example.myapplication.welcome.WelcomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun toStart() = FragmentScreen { StartFragment() }
    fun toWelcome() = FragmentScreen { WelcomeFragment() }
    fun toRegistration() = FragmentScreen { RegistrationFragment() }
    fun toNotes(userId: Int) = FragmentScreen { NotesFragment.newInstance(userId) }
    fun toNoteAdd(userId: Int) = FragmentScreen { NoteAddFragment.newInstance(userId) }
    fun toUser(user: User) = FragmentScreen { FeaturesScreenFragment.newInstance(user) }
    fun toAuthorization() = FragmentScreen { AuthorizationFragment() }
    fun toProfile(userId: Int) = FragmentScreen { ProfileFragment.newInstance(userId) }
    fun toSettings(userId: Int) = FragmentScreen { SettingsFragment.newInstance(userId) }
    fun toHotelList() = FragmentScreen { HotelListFragment() }
    fun toHotelDetailed(id: Int) = FragmentScreen { HotelDetailedFragment.newInstance(id) }
    fun toNoteEdit(userId: Int, noteId: Int) =
        FragmentScreen { NoteEditFragment.newInstance(userId, noteId) }
}