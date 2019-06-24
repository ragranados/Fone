package com.example.fonetesting.architecture_components

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_game1")
data class game1(
    @ColumnInfo(name= "nivel") val nivel:Int = 0

    ) {
    @PrimaryKey(autoGenerate = true) var id :Long = 0
}