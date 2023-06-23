package com.example.filmmodu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmmodu.model.FavoriteItem
import com.example.filmmodu.repository.FavoriteRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: FavoriteRepository) : ViewModel() {
    private val _favorites = MutableLiveData<List<FavoriteItem>>()
    val favorites: LiveData<List<FavoriteItem>> get() = _favorites



    fun insertFavorite(favorite: FavoriteItem) {
        viewModelScope.launch {
            repository.insertFavorite(favorite)
        }
    }

    fun deleteFavorite(favorite: FavoriteItem) {
        viewModelScope.launch {
            repository.deleteFavorite(favorite)
        }

    }}