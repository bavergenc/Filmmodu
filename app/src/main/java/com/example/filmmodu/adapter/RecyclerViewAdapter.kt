package com.example.filmmodu.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.navArgument
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmmodu.databinding.MovieListItemBinding
import com.example.filmmodu.model.MovieModel
import com.example.filmmodu.ui.fragment.HomeFragmentDirections
import com.example.filmmodu.ui.fragment.MovieDetailFragment

class RecyclerViewAdapter(val onItemClicked: (MovieModel) -> Unit, var modelArraylist:List<MovieModel>,var context: Context): RecyclerView.Adapter<ReciyclerViewHolder>() {
    lateinit var courseModelArrayList: ArrayList<MovieModel>


    fun updateData(newData: List<MovieModel>) {
        modelArraylist = newData
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReciyclerViewHolder {
        val mBinding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ReciyclerViewHolder(mBinding)
    }


    override fun onBindViewHolder(holder: ReciyclerViewHolder, position: Int) {


        holder.list_item_binding.tvMovieName.text = modelArraylist.get(position).movie_name

        Glide.with(context).load(modelArraylist[position].movie_poster).into(holder.list_item_binding.ivMoviePoster)


        holder.itemView.setOnClickListener {
            onItemClicked(modelArraylist[position])



        }
    }

    override fun getItemCount(): Int {
        return modelArraylist.size
    }
}

class ReciyclerViewHolder(var list_item_binding: MovieListItemBinding):RecyclerView.ViewHolder(list_item_binding.root){
}