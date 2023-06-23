package com.example.filmmodu.model

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "favorites")
data class FavoriteItem(
    @PrimaryKey
    var movie_imdb_id:String,
    var movie_name:String,
    var movie_genres:String,
    var movie_year:Int,
    var movie_iframe:String,
    var movie_poster:String,
    var movie_description:String
    )

