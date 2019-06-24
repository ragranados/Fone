package com.example.fonetesting.architecture_components

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [game1::class], version = 2, exportSchema = false)
abstract class GameRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): game1Dao

    companion object {
        @Volatile
        private var INSTANCE: GameRoomDatabase?=null

        fun getDatabase(context: Context, scope: CoroutineScope): GameRoomDatabase {

            return INSTANCE ?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    GameRoomDatabase::class.java,
                    "Book_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabseCall(scope))
                    .build()
                INSTANCE= instance
                instance
            }

        }
    }

    private class DatabseCall(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            INSTANCE?.let { appDatabase ->
                scope.launch(Dispatchers.IO) {
                    LlenarDB(appDatabase.gameDao())
                }
            }
        }


        suspend fun LlenarDB(game1: game1Dao) {
            var game= game1(0)

            game1.insert(game)

           /* var game= game1( arrayOf("papa", "queso", "pequeño", "tarde", "grama", "tapadera", "broma"),
                arrayOf("pa_a", "_ueso", "pe_ueño", "ta_de", "_rama", "ta_adera", "_roma"),
                arrayOf("p", "p", "p", "r", "g", "b"), arrayOf("q", "q", "q", "l", "q", "p")  )

            game1.insert(game)*/

        }
    }

}