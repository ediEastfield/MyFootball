package com.dicoding.myfootball.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListEventResponse(

    @field:SerializedName("events")
    val events: List<EventResponse>

)
