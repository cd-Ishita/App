package com.example.myapplication.ingredients

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.network.MyRecipe

class IngredientsViewModel(myRecipe: MyRecipe, app: Application) : AndroidViewModel(app) {
    private val _selectedRecipe = MutableLiveData<MyRecipe>()

    val selectedRecipe: LiveData<MyRecipe>
        get() = _selectedRecipe

    init {
        _selectedRecipe.value = myRecipe
    }

}