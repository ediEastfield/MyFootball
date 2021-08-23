package com.dicoding.myfootball.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class EventResponse(

    @field:SerializedName("idEvent")
    val eventId: String,
    @field:SerializedName("strEvent")
    val event: String,
    @field:SerializedName("idLeague")
    val leagueId: String,
    @field:SerializedName("strLeague")
    val league: String,
    @field:SerializedName("strSeason")
    val season: String,
    @field:SerializedName("strDescriptionEN")
    val description: String,
    @field:SerializedName("strHomeTeam")
    val homeTeam: String,
    @field:SerializedName("strAwayTeam")
    val awayTeam: String,
    @field:SerializedName("intHomeScore")
    val homeScore: String,
    @field:SerializedName("intRound")
    val round: String,
    @field:SerializedName("intAwayScore")
    val awayScore: String,
    @field:SerializedName("dateEvent")
    val dateEvent: String,
    @field:SerializedName("idHomeTeam")
    val homeTeamId: String,
    @field:SerializedName("idAwayTeam")
    val awayTeamId: String,
    @field:SerializedName("strVenue")
    val venue: String,
    @field:SerializedName("strThumb")
    val thumb: String,
    @field:SerializedName("strStatus")
    val status: String,
    @field:SerializedName("strVideo")
    val video: String

)
