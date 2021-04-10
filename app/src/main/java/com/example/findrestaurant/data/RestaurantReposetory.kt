package com.example.findrestaurant.data

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.room.withTransaction
import com.example.findrestaurant.API.RestauarantApi
import com.example.findrestaurant.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantReposetory @Inject constructor(
    private val dao: RestaurantDao,
    private val Api: RestauarantApi,
    private val db: RestaurantsDB
) {

    fun getRestauarents() = networkBoundResource(
        query = {
            dao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            Api.getrestaurant()
        },
        saveFetchedResult = {
            db.withTransaction {
                dao.deleteAllRestaurants()
                dao.insertRestuarents(it)
            }


        }

    )
}