package com.dicoding.myfootball.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.myfootball.core.data.source.local.entity.EventEntity
import com.dicoding.myfootball.core.data.source.local.entity.LeagueEntity
import com.dicoding.myfootball.core.data.source.local.entity.StandingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MyFootballDao {

    @Query("SELECT * FROM league")
    fun getAllLeague(): Flow<List<LeagueEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeague(league: List<LeagueEntity>)

    @Query("SELECT * FROM standing WHERE leagueId =:leagueId ORDER BY cast(rank as unsigned) ASC")
    fun getStandingLeague(leagueId: String): Flow<List<StandingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStandingLeague(standingLeague: List<StandingEntity>)

    @Query("SELECT * FROM event ORDER BY dateEvent ASC")
    fun getMatchResults(): Flow<List<EventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatchResult(matchResult: List<EventEntity>)
}