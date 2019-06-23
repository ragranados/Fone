package com.example.fonetesting.architecture_components

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_game1")
data class game1(
    /*@ColumnInfo(name = "lista1") val lista1:ArrayList<String> ,
    @ColumnInfo(name = "lista2") val lista2:ArrayList<String> ,
    @ColumnInfo(name = "listaopcion1") val listaopcion1:ArrayList<String> ,
    @ColumnInfo(name = "listaopcion2") val listaopcion2:ArrayList<String> ,*/
    @ColumnInfo(name= "nivel") val nivel:Int = 0

    ) {
    @PrimaryKey(autoGenerate = true) var id :Long = 0
}