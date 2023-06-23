package com.example.filmmodu.repository

import com.example.filmmodu.Dao.FavoriteDao
import com.example.filmmodu.Dao.FavouriteDatabase
import com.example.filmmodu.model.FavoriteItem

class FavoriteRepository(private val favoriteDao: FavoriteDao) {

    suspend fun insertFavorite(favorite: FavoriteItem) {
        favoriteDao.insertFavorite(favorite)
    }

    suspend fun deleteFavorite(favorite: FavoriteItem) {
        favoriteDao.deleteFavorite(favorite)
    }

    suspend fun getAllFavorites(): List<FavoriteItem> {
        return favoriteDao.getAllFavorites()
    }
}