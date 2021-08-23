package com.dicoding.myfootball.core.data.source.local

import com.dicoding.myfootball.core.data.source.local.entity.EventEntity
import com.dicoding.myfootball.core.data.source.local.entity.LeagueEntity
import com.dicoding.myfootball.core.data.source.local.entity.StandingEntity
import com.dicoding.myfootball.core.data.source.local.room.MyFootballDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val myFootballDao: MyFootballDao) {

    fun getAllLeague(): Flow<List<LeagueEntity>> = myFootballDao.getAllLeague()

    suspend fun insertLeague(leagueList: List<LeagueEntity>) = myFootballDao.insertLeague(leagueList)

    fun getStandingLeague(leagueId: String): Flow<List<StandingEntity>> = myFootballDao.getStandingLeague(leagueId)

    suspend fun insertStandingLeague(standingLeagueList: List<StandingEntity>) = myFootballDao.insertStandingLeague(standingLeagueList)

    fun getMatchResults(): Flow<List<EventEntity>> = myFootballDao.getMatchResults()

    suspend fun insertMatchResults(matchResultList: List<EventEntity>) = myFootballDao.insertMatchResult(matchResultList)
}