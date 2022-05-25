package com.example.githubclient.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubclient.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}