package com.example.myapplication.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentIngredientsBinding
import kotlinx.android.synthetic.main.fragment_ingredients.*

class IngredientsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentIngredientsBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val myRecipe = IngredientsFragmentArgs.fromBundle(arguments!!).selectedRecipe
        val viewModelFactory = IngredientsViewModelFactory(myRecipe, application)
        binding.viewModel = ViewModelProviders.of(this, viewModelFactory).get(IngredientsViewModel::class.java)



        binding.nextButton.setOnClickListener{view: View ->

//            if(null != myRecipe.strInstructions) {
//                val selection = myRecipe.strInstructions
//            }

            val selection: String = myRecipe.strInstructions ?: "Sorry"

            val actionDetail = IngredientsFragmentDirections.actionIngredientsFragmentToInstructionsFragment()
            actionDetail.setSelection(selection)
            view.findNavController().navigate(actionDetail)
            //view.findNavController().navigate(IngredientsFragmentDirections.actionIngredientsFragmentToInstructionsFragment(selection))
        }
        return binding.root
    }
}