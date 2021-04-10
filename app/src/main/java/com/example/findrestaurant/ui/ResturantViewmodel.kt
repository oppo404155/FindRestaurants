package com.example.findrestaurant.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.findrestaurant.API.RestauarantApi
import com.example.findrestaurant.data.RestaurantReposetory
import com.example.findrestaurant.data.Resturant
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResturantViewmodel @Inject constructor(
    private val Repo:RestaurantReposetory
):ViewModel(){

         val RestuarantLiveData=Repo.getRestauarents().asLiveData()


}