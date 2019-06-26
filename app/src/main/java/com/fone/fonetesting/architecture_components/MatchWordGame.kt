package com.fone.fonetesting.architecture_components

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_matchwordgame")
data class MatchWordGame(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "passed") val passed: Boolean
) {
    //@PrimaryKey(autoGenerate = true) var id : Long = 0
}