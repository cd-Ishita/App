package com.example.myapplication.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentIngredientsBinding
import kotlinx.android.synthetic.main.fragment_ingredients.*

class IngredientsFragment : Fragment() {

    private lateinit var viewModel: IngredientsViewModel

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

//        binding.nextButton.setOnClickListener{view: View ->
//            if(null != myRecipe.strInstructions) {
//                val selection = myRecipe.strInstructions
//            }

//            val selection: String = myRecipe.strInstructions ?: "Sorry"
//
//            val actionDetail = IngredientsFragmentDirections.actionIngredientsFragmentToInstructionsFragment()
//            actionDetail.setSelection(selection)
//            view.findNavController().navigate(actionDetail)
            //view.findNavController().navigate(IngredientsFragmentDirections.actionIngredientsFragmentToInstructionsFragment(selection))
//        }

//        viewModel.onClick.observe(this, Observer<Boolean> {
//            isClicked ->
//            if(isClicked) {
//                myFunction()
//            }
//        })
//        return binding.root
//    }
//
//    private fun myFunction() {
//        val action = IngredientsFragmentDirections.actionIngredientsFragmentToInstructionsFragment()
//        action.selection = viewModel.selectedRecipe.value?.strInstructions.toString()
//        view?.findNavController()?.navigate(action)
//        viewModel.onClickedComplete()
