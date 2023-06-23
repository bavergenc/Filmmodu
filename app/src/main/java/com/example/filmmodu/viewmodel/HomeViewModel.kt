package com.example.filmmodu.viewmodel

import androidx.lifecycle.ViewModel
import com.example.filmmodu.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val homeRepository:HomeRepository):ViewModel() {

    fun getMoviesData() = homeRepository.getMovies()

}