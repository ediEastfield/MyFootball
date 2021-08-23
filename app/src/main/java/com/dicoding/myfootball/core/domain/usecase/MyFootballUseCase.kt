package com.dicoding.myfootball.core.domain.usecase

import com.dicoding.myfootball.core.data.Resource
import com.dicoding.myfootball.core.domain.model.Event
import com.dicoding.myfootball.core.domain.model.League
import com.dicoding.myfootball.core.domain.model.Standing
import kotlinx.coroutines.flow.Flow

interface MyFootballUseCase {

    fun getAllLeague(): Flow<Resource<List<League>>>

    fun getStandingLeague(leagueId: String, season: String): Flow<Resource<List<Standing>>>

    fun getMatchResult(leagueId: String): Flow<Resource<List<Event>>>
}