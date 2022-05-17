package com.example.examenalberto.Movi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examenalberto.databinding.ItemMoviBinding

class MoviViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemMoviBinding.bind(view)
    fun render(item2: Result_) {
        binding.tvtitle.text = item2.original_title
        binding.tvoverview.text = item2.overview
        binding.tvoriginallanguage.text = item2.original_language
        Glide.with(binding.ivPortada.context).load("https://image.tmdb.org/t/p/w500" + item2.backdrop_path).into(binding.ivPortada)
    }
}


