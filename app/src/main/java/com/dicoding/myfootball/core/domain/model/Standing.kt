package com.dicoding.myfootball.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Standing(
    val standingId: String,
    val leagueId: String,
    val rank: String,
    val teamId: String,
    val badgeTeam: String,
    val team: String,
    val played: String,
    val win: String,
    val draw: String,
    val lost: String,
    val goalsFor: String,
    val goalsAgainst: String,
    val goalDifference: String,
    val points: String
): Parcelable
