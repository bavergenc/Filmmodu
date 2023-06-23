package com.example.filmmodu.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.filmmodu.Dao.FavoriteDao
import com.example.filmmodu.Dao.FavouriteDatabase
import com.example.filmmodu.R
import com.example.filmmodu.databinding.FragmentMovieDetailBinding
import com.example.filmmodu.model.FavoriteItem
import com.example.filmmodu.model.MovieModel
import com.example.filmmodu.model.ProviderFactory
import com.example.filmmodu.repository.FavoriteRepository
import com.example.filmmodu.viewmodel.FavoriteViewModel
import javax.inject.Inject


class MovieDetailFragment : DialogFragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    val viewModel: FavoriteViewModel by viewModels()
    lateinit var movieList:List<FavoriteItem>
    @Inject
    lateinit var  repository: FavoriteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogTheme)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailBinding.inflate(layoutInflater)
        val view =binding.root

        val favoriteDao = FavouriteDatabase.getDatabase(requireContext()).favouriteDao()
        repository = FavoriteRepository(favoriteDao)

        val note = FavoriteItem("", "","",0,"","","")

        binding.favButton.setOnClickListener {
            addToFavorites(note)
        }


        try {
            val movieData = requireArguments().getSerializable("movie") as MovieModel
            binding.movieName.text=movieData.movie_name
            binding.movieDescription.text=movieData.movie_description
            binding.movieYear.text=movieData.movie_year.toString()

            Glide.with(this).load(movieData.movie_poster).into(binding.imageView)

        } catch (e: Exception) {
        }

//        val bundle=navArgs<MovieDetailFragmentArgs>()
//        val movieData=bundle.value.selectedMovie


        return view
    }

    fun addToFavorites(favorite: FavoriteItem) {

        val factory = ProviderFactory(repository)
        val viewModel: FavoriteViewModel = ViewModelProvider(this, factory).get(FavoriteViewModel::class.java)
        viewModel.insertFavorite(favorite)
    }



//    fun getFavorites() {
//        val viewModel: FavoriteViewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
//        viewModel.favorites.observe(this, { favorites ->
//
//        })
//    }

}