package com.example.findrestaurant.data

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Inject

@Database(entities = [Resturant::class],version = 1)
abstract class RestaurantsDB:RoomDatabase() {
    abstract fun RestaurantDao():RestaurantDao
}