package com.example.findrestaurant.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Resturant(
    @PrimaryKey val name: String,
    val type: String,
    val logo: String,
    val address: String
)
