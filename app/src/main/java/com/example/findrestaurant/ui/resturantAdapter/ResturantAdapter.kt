package com.example.findrestaurant.ui.resturantAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.findrestaurant.data.Resturant
import com.example.findrestaurant.databinding.ResturantItemBinding

class ResturantAdapter : ListAdapter<Resturant, ResturantAdapter.viewholder>(itemCallback) {

    var onItemClick: ((Resturant) -> Unit)? = null


  inner class viewholder(private val binding: ResturantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

       init {
           itemView.setOnClickListener{
          onItemClick?.invoke(getItem(adapterPosition))
           }
       }
        fun bind(resturant: Resturant) {
            binding.apply {
                txvName.text = resturant.name
                txvType.text = resturant.type
                txvAddress.text = resturant.address
                Glide.with(itemView).load(resturant.logo).into(imageItemLogo)

            }






        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = ResturantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewholder(view)

    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }


    }
    companion object {
        private val itemCallback=object : DiffUtil.ItemCallback<Resturant>() {
            override fun areContentsTheSame(oldItem: Resturant, newItem: Resturant): Boolean {
  return oldItem==newItem
            }

            override fun areItemsTheSame(oldItem: Resturant, newItem: Resturant): Boolean {
           return oldItem.name==newItem.name
            }

        }
    }
}