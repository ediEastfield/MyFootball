package com.dicoding.myfootball.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    val leagueId: String,
    val league: String,
    val badge: String,
    val description: String,
    val trophy: String?,
    val fanArt: String?,
    val currentSeason: String
) : Parcelable
