package com.example.movieapiretrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapiretrofit.databinding.FragmentListBinding


@Suppress("DEPRECATION")
class ListFragment : Fragment(R.layout.fragment_list) {

    private var lbinding:FragmentListBinding? = null
    private val binding get() = lbinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleCharacters.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }

        binding.btnFilter.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lbinding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        lbinding = null
    }

}