package com.dicoding.myfootball.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val eventId: String,
    val event: String,
    val leagueId: String,
    val league: String,
    val season: String,
    val description: String,
    val homeTeam: String,
    val awayTeam: String,
    val homeScore: String,
    val round: String,
    val awayScore: String,
    val dateEvent: String,
    val homeTeamId: String,
    val awayTeamId: String,
    val venue: String,
    val thumb: String,
    val status: String,
    val video: String
) : Parcelable