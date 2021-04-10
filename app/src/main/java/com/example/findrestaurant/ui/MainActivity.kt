package com.example.findrestaurant.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.findrestaurant.R
import com.example.findrestaurant.databinding.ActivityMainBinding
import com.example.findrestaurant.ui.resturantAdapter.ResturantAdapter
import com.example.findrestaurant.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewmodel:ResturantViewmodel by viewModels()
   // private val binding:ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restuarantAdapter=ResturantAdapter()
       binding.apply {
           RestuarantRecycle.apply {
               layoutManager=LinearLayoutManager(this@MainActivity)
               adapter=restuarantAdapter

           }
           viewmodel.RestuarantLiveData.observe(this@MainActivity){Results->
               restuarantAdapter.submitList(Results.data)
               progressBar.isVisible=Results is Resource.Loading && Results.data.isNullOrEmpty()
               txvErrorMessage.isVisible=Results is Resource.Error && Results.data.isNullOrEmpty()
               txvErrorMessage.text=Results.erorr?.localizedMessage

           }
           restuarantAdapter.onItemClick={
               Toast.makeText(this@MainActivity,
                   "${it.name} is a good choice" ,
                   Toast.LENGTH_SHORT).show()
           }
       }






    }


}
