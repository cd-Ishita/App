package com.example.myapplication.overview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProviders.of(this).get(OverviewViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //val binding = GridViewItemBinding.inflate(inflater)
        val binding = FragmentOverviewBinding.inflate(inflater)


        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

//        val myText = findViewById<EditText>(R.id.editTextSearch)
//        var myText = binding.editTextSearch

        val myText = binding.root.findViewById<EditText>(R.id.editTextSearch)


        myText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable) {
                //viewModel.text(p0.toString())
                var new = binding.editTextSearch.getText().toString()
                viewModel.text(new)
            }

        })

        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
           viewModel.displayRecipeIngredients(it)
        })

        viewModel.navigateToSelectedRecipe.observe(this, Observer {
            if (null != it) {
                this.findNavController().navigate(OverviewFragmentDirections.actionShowIngredients(it))
                viewModel.displayRecipeIngredientsComplete()
            }
        })

        return binding.root
    }
}
