package com.example.movieapiretrofit.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.movieapiretrofit.databinding.FragmentDetailBinding
import com.example.movieapiretrofit.databinding.FragmentFilterBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private var fbinding: FragmentDetailBinding? = null
    private val binding get() = fbinding!!

    private val args: DetailFragmentArgs by navArgs()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = args.character

        binding.apply {
            txtId.text = character.id.toString()
            txtStatus.text = character.status
            Picasso.get().load(character.image).into(imgCharacterDetail)
            txtName.text = character.name
            txtSpecie.text = character.species
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}