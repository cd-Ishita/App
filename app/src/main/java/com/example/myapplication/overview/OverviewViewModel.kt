package com.example.myapplication.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.network.MyApi
import com.example.myapplication.network.MyRecipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class MyApiStatus {LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<MyApiStatus>()

    // The external immutable LiveData for the request status String
    val status: LiveData<MyApiStatus>
        get() = _status

    private val _recipes = MutableLiveData<List<MyRecipe>>()
    val recipes: LiveData<List<MyRecipe>>
        get() = _recipes

    private val _navigateToSelectedRecipe = MutableLiveData<MyRecipe>()
    val navigateToSelectedRecipe : LiveData<MyRecipe>
        get() = _navigateToSelectedRecipe

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {

        getRecipes()
    }

    private fun getRecipes() {
    /*    MyApi.retrofitService.getRecipes().enqueue( object: Callback<Bleh> {

            override fun onFailure(call: Call<Bleh>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<Bleh>, response: Response<Bleh>) {
                _response.value = "Success: ${response.body()?.meals?.size}"
            }
        })*/

        coroutineScope.launch {
            var getRecipesDeferred = MyApi.retrofitService.getRecipes()
            try {

                _status.value = MyApiStatus.LOADING

                var listResult = getRecipesDeferred.await()
                _status.value = MyApiStatus.DONE
                _recipes.value = listResult.meals
            } catch (e: Exception) {
                _status.value = MyApiStatus.ERROR
                _recipes.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayRecipeIngredients (myRecipe: MyRecipe) {
        _navigateToSelectedRecipe.value = myRecipe
    }

    fun displayRecipeIngredientsComplete() {
        _navigateToSelectedRecipe.value = null
    }
}

