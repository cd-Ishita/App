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

//    val _onClick = MutableLiveData<Boolean>()
//    val onClick: LiveData<Boolean>
//        get() = _onClick
//
//    val _meme = MutableLiveData<String>()
//    val meme: LiveData<String>
//        get() = _meme



//    fun onClicked() {
//        _onClick.value = true
//    }
//
//    fun onClickedComplete() {
//        _onClick.value = false
//    }
