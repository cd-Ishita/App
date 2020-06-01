package com.example.myapplication

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.network.MyRecipe
import com.example.myapplication.overview.MyApiStatus
import com.example.myapplication.overview.PhotoGridAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MyRecipe>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("myApiStatus")
fun bindStatus(statusImageView: ImageView, status: MyApiStatus?) {
    when (status) {
        MyApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MyApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MyApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

//@BindingAdapter("ingredientValue")
//fun ingredientValue(statusCheckBox: CheckBox, status: IngredientValue?) {
//    when (status) {
//        IngredientValue.NULL -> {
//            statusCheckBox.visibility = View.GONE
//        }
//
//        IngredientValue.FILL -> {
//            statusCheckBox.visibility = View.VISIBLE
//        }
//    }
//}
