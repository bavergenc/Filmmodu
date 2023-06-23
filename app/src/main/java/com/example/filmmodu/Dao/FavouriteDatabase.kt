package com.example.filmmodu.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filmmodu.model.FavoriteItem

@Database(entities = [FavoriteItem::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: FavouriteDatabase? = null

        fun getDatabase(context: Context): FavouriteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteDatabase::class.java,
                    "favourite_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}




