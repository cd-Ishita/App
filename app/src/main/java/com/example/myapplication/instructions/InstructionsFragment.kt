package com.example.myapplication.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.InstructionsFragmentBinding
import com.example.myapplication.instructions.InstructionsFragmentArgs
import com.example.myapplication.instructions.InstructionsFragmentArgs.fromBundle
import kotlinx.android.synthetic.main.instructions_fragment.*

class InstructionsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = InstructionsFragmentBinding.inflate(inflater)
        //val name = InstructionsFragmentArgs.fromBundle(arguments!!).selection
//        val recipe = name.strInstructions
//        if(name != null)
//            the_recipe.text = name
//        else
//            the_recipe.text = "Sorry, not found"

        arguments?.let{
            val safeArgs = InstructionsFragmentArgs.fromBundle(it)
            val selection = safeArgs.selection
            the_recipe.text = selection ?: "Sorry"
        }



        binding.setLifecycleOwner(this)


        return binding.root
    }


}