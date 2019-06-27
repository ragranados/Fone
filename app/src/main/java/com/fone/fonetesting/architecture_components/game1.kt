package com.fone.fonetesting.architecture_components

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_game1")
data class game1(
    @ColumnInfo(name= "nivel_juego1") val nivel_juego1:Int = 0,
    @ColumnInfo(name= "nivel_juego2") val nivel_juego2:Int = 0

    ) {
    @PrimaryKey(autoGenerate = true) var id :Long = 0
}