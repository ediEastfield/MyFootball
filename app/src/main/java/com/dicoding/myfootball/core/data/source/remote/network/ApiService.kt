package com.dicoding.myfootball.core.data.source.remote.network

import com.dicoding.myfootball.core.data.source.remote.response.ListEventResponse
import com.dicoding.myfootball.core.data.source.remote.response.ListLeagueResponse
import com.dicoding.myfootball.core.data.source.remote.response.ListStandingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search_all_leagues.php")
    suspend fun getListLeague(
        @Query("c") q: String = "England",
        @Query("s") s: String = "Soccer",
    ): ListLeagueResponse

    @GET("lookuptable.php")
    suspend fun getListStanding(
        @Query("l") l: String,
        @Query("s") s: String,
    ): ListStandingResponse

    @GET("eventspastleague.php")
    suspend fun getListMatchResults(
        @Query("id") id: String
    ): ListEventResponse

}