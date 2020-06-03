package com.example.myapplication.instructions

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentIngredientsBinding.inflate
import com.example.myapplication.databinding.InstructionsFragmentBinding
import com.example.myapplication.ingredients.IngredientsViewModel
import com.example.myapplication.network.MyRecipe
import kotlinx.android.synthetic.main.instructions_fragment.*

class InstructionsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = InstructionsFragmentBinding.inflate(inflater)
        val name = InstructionsFragmentArgs.fromBundle(arguments!!).selection
        val recipe = name.strMeal
        if(recipe != null)
            the_recipe.text = recipe.toString()
        else
            the_recipe.text = "Sorry, not found"
        binding.setLifecycleOwner(this)


        return binding.root
    }


}