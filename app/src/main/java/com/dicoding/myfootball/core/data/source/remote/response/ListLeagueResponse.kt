package com.dicoding.myfootball.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListLeagueResponse(

    @field:SerializedName("countrys")
    val league: List<LeagueResponse>
)
