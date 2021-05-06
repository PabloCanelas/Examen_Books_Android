package com.example.examen3_canelas.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book:: class], version = 1, exportSchema = false )
abstract class BookDB : RoomDatabase() {

    abstract fun bookDao ():IBookDao

    companion object{
        @Volatile
        private var INSTANCE:BookDB? = null

        fun getDatabase(context: Context):BookDB{
            val tempInstance = INSTANCE
            if (tempInstance != null ){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDB::class.java,
                    "book_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}