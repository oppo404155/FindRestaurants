package com.example.findrestaurant.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestuarents(resturants: List<Resturant>)

    @Query("select * from restaurants ")
    fun getAllRestaurants():Flow<List<Resturant>>

    @Query("delete from restaurants")
    suspend fun deleteAllRestaurants()

}