package com.example.movieapiretrofit.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapiretrofit.R
import com.example.movieapiretrofit.ui.SharedViewModelFactory
import com.example.movieapiretrofit.api.Repository
import com.example.movieapiretrofit.databinding.FragmentListBinding
import com.example.movieapiretrofit.ui.SharedViewModel


@Suppress("DEPRECATION")
class ListFragment : Fragment(R.layout.fragment_list) {

    private var lbinding:FragmentListBinding? = null
    private val binding get() = lbinding!!
    private val sharedViewModel: SharedViewModel by activityViewModels { SharedViewModelFactory(
        Repository()
    ) }
    private var adapter = CharacterAdapter()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel.getCharacters(1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.listCharacters.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                adapter.setCharacters(response.body()!!.results)
                //Log.d("Result", response.body()!!.results.toString())
            } else {
                Log.d("ResultError", response.code().toString())
            }
        }
        binding.apply {
            recyclerview.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            recyclerview.adapter = adapter

            binding.btnFilter.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_filterFragment)
            }
        }

        binding.titleCharacters.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
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