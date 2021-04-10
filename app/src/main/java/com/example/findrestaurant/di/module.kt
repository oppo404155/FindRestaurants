package com.example.findrestaurant.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.findrestaurant.API.RestauarantApi
import com.example.findrestaurant.data.RestaurantDao
import com.example.findrestaurant.data.RestaurantsDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object module {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(RestauarantApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):
            RestauarantApi = retrofit.create(RestauarantApi::class.java)

    @Singleton
    @Provides
    fun providerRestaurantDB(app: Application): RestaurantsDB =
        Room.databaseBuilder(app, RestaurantsDB::class.java, "Restaurant_DataBase")
            .fallbackToDestructiveMigration()
            .build()
    @Singleton
    @Provides
    fun provideRestaurantDao(roomDB:RestaurantsDB):RestaurantDao=
        roomDB.RestaurantDao()

}