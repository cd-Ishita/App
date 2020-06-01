package com.example.myapplication.ingredients

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.network.MyRecipe

class IngredientsViewModelFactory(
    private val myRecipe: MyRecipe,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IngredientsViewModel::class.java)) {
            return IngredientsViewModel(myRecipe, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
