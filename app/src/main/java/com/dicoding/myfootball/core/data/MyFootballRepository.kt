package com.dicoding.myfootball.core.data

import com.dicoding.myfootball.core.data.source.local.LocalDataSource
import com.dicoding.myfootball.core.data.source.remote.RemoteDataSource
import com.dicoding.myfootball.core.data.source.remote.network.ApiResponse
import com.dicoding.myfootball.core.data.source.remote.response.EventResponse
import com.dicoding.myfootball.core.data.source.remote.response.LeagueResponse
import com.dicoding.myfootball.core.data.source.remote.response.StandingResponse
import com.dicoding.myfootball.core.domain.model.Event
import com.dicoding.myfootball.core.domain.model.League
import com.dicoding.myfootball.core.domain.model.Standing
import com.dicoding.myfootball.core.domain.repository.IMyFootballRepository
import com.dicoding.myfootball.core.utils.AppExecutors
import com.dicoding.myfootball.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyFootballRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMyFootballRepository {

    override fun getAllLeague(): Flow<Resource<List<League>>> =
        object : NetworkBoundResource<List<League>, List<LeagueResponse>>() {
            override fun loadFromDB(): Flow<List<League>> {
                return localDataSource.getAllLeague().map {
                    DataMapper.mapLeagueEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<League>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<LeagueResponse>>> =
                remoteDataSource.getAllLeague()

            override suspend fun saveCallResult(data: List<LeagueResponse>) {
                val leagueList = DataMapper.mapLeagueResponseToEntities(data)
                localDataSource.insertLeague(leagueList)
            }
        }.asFlow()

    override fun getStandingLeague(leagueId: String, season: String): Flow<Resource<List<Standing>>> =
        object : NetworkBoundResource<List<Standing>, List<StandingResponse>>() {
            override fun loadFromDB(): Flow<List<Standing>> {
                return localDataSource.getStandingLeague(leagueId).map {
                    DataMapper.mapStandingEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Standing>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<StandingResponse>>> =
                remoteDataSource.getStandingLeague(leagueId, season)

            override suspend fun saveCallResult(data: List<StandingResponse>) {
                val standingLeagueList = DataMapper.mapStandingResponsesToEntities(data)
                localDataSource.insertStandingLeague(standingLeagueList)
            }
        }.asFlow()

    override fun getMatchResult(leagueId: String): Flow<Resource<List<Event>>> =
        object : NetworkBoundResource<List<Event>, List<EventResponse>>() {
            override fun loadFromDB(): Flow<List<Event>> {
                return localDataSource.getMatchResults().map {
                    DataMapper.mapEventEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Event>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<EventResponse>>> =
                remoteDataSource.getMatchResults(leagueId)

            override suspend fun saveCallResult(data: List<EventResponse>) {
                val matchResultList = DataMapper.mapEventResponsesToEntities(data)
                localDataSource.insertMatchResults(matchResultList)
            }
        }.asFlow()

}