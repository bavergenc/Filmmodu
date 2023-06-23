package com.example.filmmodu.Dao

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.filmmodu.model.FavoriteItem

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteItem)

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteItem)

    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteItem>
}

@Database(entities = [FavoriteItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}