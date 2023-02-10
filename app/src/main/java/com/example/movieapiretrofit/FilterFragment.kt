package com.example.movieapiretrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapiretrofit.databinding.FragmentFilterBinding


class FilterFragment : Fragment() {

    private var fbinding: FragmentFilterBinding? = null
    private val binding get() = fbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*btnApplyFilter.setOnClickListener{
            findNavController().popBackStack()
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentFilterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}