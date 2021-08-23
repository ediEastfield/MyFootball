package com.dicoding.myfootball.core.data.source.remote

import android.util.Log
import com.dicoding.myfootball.core.data.source.remote.network.ApiResponse
import com.dicoding.myfootball.core.data.source.remote.network.ApiService
import com.dicoding.myfootball.core.data.source.remote.response.EventResponse
import com.dicoding.myfootball.core.data.source.remote.response.LeagueResponse
import com.dicoding.myfootball.core.data.source.remote.response.StandingResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllLeague(): Flow<ApiResponse<List<LeagueResponse>>> {
        return flow {
            try {
                val response = apiService.getListLeague()
                val dataArray = response.league
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.league))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getStandingLeague(l: String, s: String): Flow<ApiResponse<List<StandingResponse>>> {
        return  flow {
            try {
                val response = apiService.getListStanding(l, s)
                val dataArray = response.table
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.table))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMatchResults(leagueId: String): Flow<ApiResponse<List<EventResponse>>> {
        return  flow {
            try {
                val response = apiService.getListMatchResults(leagueId)
                val dataArray = response.events
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.events))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}