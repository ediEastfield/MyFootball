package com.dicoding.myfootball.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "standing")
data class StandingEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "standingId")
    var standingId: String,

    @ColumnInfo(name = "leagueId")
    var leagueId: String,

    @ColumnInfo(name = "rank")
    var rank: String,

    @ColumnInfo(name = "teamId")
    var teamId: String,

    @ColumnInfo(name = "badgeTeam")
    var badgeTeam: String,

    @ColumnInfo(name = "team")
    var team: String,

    @ColumnInfo(name = "played")
    var played: String,

    @ColumnInfo(name = "win")
    var win: String,

    @ColumnInfo(name = "draw")
    var draw: String,

    @ColumnInfo(name = "lost")
    var lost: String,

    @ColumnInfo(name = "goalsFor")
    var goalsFor: String,

    @ColumnInfo(name = "goalsAgainst")
    var goalsAgainst: String,

    @ColumnInfo(name = "goalDifference")
    var goalDifference: String,

    @ColumnInfo(name = "points")
    var points: String,
)
