package com.dicoding.myfootball.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "eventId")
    var eventId: String,

    @ColumnInfo(name = "event")
    var event: String,

    @ColumnInfo(name = "leagueId")
    var leagueId: String,

    @ColumnInfo(name = "league")
    var league: String,

    @ColumnInfo(name = "season")
    var season: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "homeTeam")
    var homeTeam: String,

    @ColumnInfo(name = "awayTeam")
    var awayTeam: String,

    @ColumnInfo(name = "homeScore")
    var homeScore: String,

    @ColumnInfo(name = "round")
    var round: String,

    @ColumnInfo(name = "awayScore")
    var awayScore: String,

    @ColumnInfo(name = "dateEvent")
    var dateEvent: String,

    @ColumnInfo(name = "homeTeamId")
    var homeTeamId: String,

    @ColumnInfo(name = "awayTeamId")
    var awayTeamId: String,

    @ColumnInfo(name = "venue")
    var venue: String,

    @ColumnInfo(name = "thumb")
    var thumb: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "video")
    var video: String
)
