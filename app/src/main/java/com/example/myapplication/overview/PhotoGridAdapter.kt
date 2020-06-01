package com.example.myapplication.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.GridViewItemBinding
import com.example.myapplication.network.MyRecipe

//
//class PhotoGridAdapter: ListAdapter<MyRecipe, PhotoGridAdapter.MyRecipeViewHolder> (DiffCallBack) {
//    companion object DiffCallBack : DiffUtil.ItemCallback<MyRecipe>() {
//        override fun areItemsTheSame(oldItem: MyRecipe, newItem: MyRecipe): Boolean {
//            return oldItem === newItem
//        }
//
//        override fun areContentsTheSame(oldItem: MyRecipe, newItem: MyRecipe): Boolean {
//            return oldItem.idMeal == newItem.idMeal
//        }
//    }
//
//    class MyRecipeViewHolder (private var binding: GridViewItemBinding):
//        RecyclerView.ViewHolder(binding.root) {
//            fun bind(myRecipe: MyRecipe) {
//                binding.recipe = myRecipe
//                binding.executePendingBindings()
//            }
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): PhotoGridAdapter.MyRecipeViewHolder {
//        return MyRecipeViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
//    }
//
//    override fun onBindViewHolder(holder: PhotoGridAdapter.MyRecipeViewHolder, position: Int) {
//        val myRecipe = getItem(position)
//        holder.bind(myRecipe)
//    }
//}


class PhotoGridAdapter(val onClickListener: OnClickListener):
    ListAdapter<MyRecipe, PhotoGridAdapter.MyRecipeViewHolder> (DiffCallBack) {

    class MyRecipeViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myRecipe: MyRecipe) {
            binding.recipe = myRecipe
            binding.executePendingBindings()
        }
    }


    companion object DiffCallBack : DiffUtil.ItemCallback<MyRecipe>() {
        override fun areItemsTheSame(oldItem: MyRecipe, newItem: MyRecipe): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MyRecipe, newItem: MyRecipe): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
    //PhotoGridAdapter.MyRecipeViewHolder {
            MyRecipeViewHolder {
        return MyRecipeViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyRecipeViewHolder, position: Int) {
        val myRecipe = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(myRecipe)
        }
        holder.bind(myRecipe)
    }



    class OnClickListener(val clickListener: (myRecipe: MyRecipe) -> Unit) {
        fun onClick(myRecipe:MyRecipe) = clickListener(myRecipe)
    }
}