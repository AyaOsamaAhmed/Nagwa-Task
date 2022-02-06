package com.aya.nagwa_task.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.nagwa_task.R
import com.aya.nagwa_task.databinding.ItemMovieBinding
import com.aya.nagwa_task.domian.model.Movie
import javax.inject.Inject

class AdapterMovies @Inject constructor(
    private var list: ArrayList<Movie>):
    RecyclerView.Adapter<AdapterMovies.ViewHolderMovie>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterMovies.ViewHolderMovie {
        val binding: ItemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie, parent, false
        )

        return ViewHolderMovie(binding)
    }

    override fun onBindViewHolder(holder: AdapterMovies.ViewHolderMovie, position: Int) {
        val model = list[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return if (list.size > 0) list.size else 0
    }


    class ViewHolderMovie(binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemMovieBinding = binding
        fun bind(model: Movie) {
            itemRowBinding.model = model
            itemRowBinding.executePendingBindings()
        }
    }

}