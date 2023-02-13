package com.example.movieapiretrofit.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.SearchEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
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
        getCharactersFromViewModel()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            sharedViewModel.listCharacters.observe(viewLifecycleOwner) { response ->
                if (response.isSuccessful) {
                    adapter.setCharacters(response.body()!!.results)
                    txtApiError.visibility = View.GONE
                    recyclerview.visibility = View.VISIBLE
                    //Log.d("Result", response.body()!!.results.toString())
                } else {
                    // Log.d("ResultError", response.code().toString())
                    binding.txtApiError.text = getString(R.string.text_error, response.code())
                    txtApiError.visibility = View.VISIBLE
                    recyclerview.visibility = View.INVISIBLE
                }
            }

            recyclerview.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            recyclerview.adapter = adapter

            binding.btnFilter.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_filterFragment)
            }
        }

        binding.titleCharacters.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }

        sharedViewModel.isFilter.observe(viewLifecycleOwner) {
            binding.titleActionReset.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }
        binding.titleActionReset.setOnClickListener {
            getCharactersFromViewModel()
            sharedViewModel.filterValue.value = arrayOf(0, 0)
        }

        getNameSearchView()

    }

    private fun getNameSearchView(){

        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                sharedViewModel.getByName(query.toString())
                binding.searchview.setQuery("",false)
                binding.searchview.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })


    }

    private fun getCharactersFromViewModel() {
        sharedViewModel.getCharacters(1)
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