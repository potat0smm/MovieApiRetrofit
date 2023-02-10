package com.example.movieapiretrofit

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.movieapiretrofit.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var fbinding: FragmentListBinding? = null
    private val binding get() = fbinding!!
    private val sharedViewModel: SharedViewModel by activityViewModels {SharedViewModelFactory(
        Repository()
    )}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedViewModel.getCharacter(1)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*sharedViewModel.listCharacters.observe(viewLifecycleOwner, {response ->
            if(response.isSuccessful){
                Log.d("Result", response.body()!!.result.toString())
            }
            else{
                Log.d("Result Error",response.code().toString())
            }
        })*/




        /*binding.btnFilter.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }*/

        /*binding.titleCharacters.setOnCliclListener{
            findNavController().navigate(R.id.action_listFragment_to_detailFragment)
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
        fbinding = FragmentListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}