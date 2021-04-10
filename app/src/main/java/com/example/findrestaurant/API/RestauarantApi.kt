package com.example.findrestaurant.API

import com.example.findrestaurant.data.Resturant
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface RestauarantApi {
    @GET("restaurant/random_restaurant?size=20")
    suspend fun getrestaurant():List<Resturant>



    companion object{
        const val BASE_URL="https://random-data-api.com/api/"
    }

}