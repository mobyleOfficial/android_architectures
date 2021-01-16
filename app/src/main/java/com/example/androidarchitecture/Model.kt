package com.example.androidarchitecture

import java.util.Date

// Movie Model
data class Movie(
    val name: String,
    val id: Int,
    val releaseDate: Date
)

// View States
enum class StateEvent {
    LOADING,
    ERROR,
    SUCCESS
}