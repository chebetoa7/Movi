package com.example.examenalberto.Movi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenalberto.R


class MoviAdapter(private val moist: MutableList<Result_>): RecyclerView.Adapter<MoviViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return MoviViewHolder(layoutInflater.inflate(R.layout.item_movi, parent, false))
    }

    override fun onBindViewHolder(holder: MoviViewHolder, position: Int) {
        val item = moist[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = moist.size
}