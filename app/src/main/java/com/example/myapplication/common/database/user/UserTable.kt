package com.example.myapplication.common.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "users"
)
data class UserTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val password: String
)