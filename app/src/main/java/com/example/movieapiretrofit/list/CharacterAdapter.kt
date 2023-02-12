package com.example.movieapiretrofit.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movieapiretrofit.R
import com.example.movieapiretrofit.databinding.ItemListBinding
import com.example.movieapiretrofit.model.Character
import com.squareup.picasso.Picasso

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var listCharacters = emptyList<com.example.movieapiretrofit.model.Character>()

    class CharacterViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character){
            binding.txtIdCharacter.text = character.id.toString()
            binding.txtNameCharacter.text = character.name
            Picasso.get().load(character.image).into(binding.imgCharacter)
            //binding.txtStatusCharacter.text = character.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater,parent,false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_listFragment_to_detailFragment)
        }
    }

    fun setCharacters(character: List<com.example.movieapiretrofit.model.Character>){
        listCharacters = character
        notifyDataSetChanged()
    }


}