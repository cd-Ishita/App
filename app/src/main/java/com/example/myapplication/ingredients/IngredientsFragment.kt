package com.example.myapplication.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.FragmentIngredientsBinding

class IngredientsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentIngredientsBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val myRecipe = IngredientsFragmentArgs.fromBundle(arguments!!).selectedRecipe
        val viewModelFactory = IngredientsViewModelFactory(myRecipe, application)
        binding.viewModel = ViewModelProviders.of(this, viewModelFactory).get(IngredientsViewModel::class.java)

        return binding.root
    }
}