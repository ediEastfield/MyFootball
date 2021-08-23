package com.dicoding.myfootball.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league")
data class LeagueEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "leagueId")
    var leagueId: String,

    @ColumnInfo(name = "league")
    var league: String,

    @ColumnInfo(name = "badge")
    var badge: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "trophy")
    var trophy: String?,

    @ColumnInfo(name = "fanArt")
    var fanArt: String?,

    @ColumnInfo(name = "currentSeason")
    var currentSeason: String,
)
