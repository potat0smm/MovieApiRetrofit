package com.example.movieapiretrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapiretrofit.databinding.FragmentDetailBinding
import com.example.movieapiretrofit.databinding.FragmentFilterBinding


class DetailFragment : Fragment() {

    private var fbinding: FragmentDetailBinding? = null
    private val binding get() = fbinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}