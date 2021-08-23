package com.dicoding.myfootball.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class StandingResponse(

    @field:SerializedName("idStanding")
    val standingId: String,

    @field:SerializedName("idLeague")
    val leagueId: String,

    @field:SerializedName("intRank")
    val rank: String,

    @field:SerializedName("idTeam")
    val teamId: String,

    @field:SerializedName("strTeamBadge")
    val badgeTeam: String,

    @field:SerializedName("strTeam")
    val team: String,

    @field:SerializedName("intPlayed")
    val played: String,

    @field:SerializedName("intWin")
    val win: String,

    @field:SerializedName("intDraw")
    val draw: String,

    @field:SerializedName("intLoss")
    val lost: String,

    @field:SerializedName("intGoalsFor")
    val goalsFor: String,

    @field:SerializedName("intGoalsAgainst")
    val goalsAgainst: String,

    @field:SerializedName("intGoalDifference")
    val goalDifference: String,

    @field:SerializedName("intPoints")
    val points: String
)
