package com.dicoding.myfootball.league.standing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.myfootball.core.domain.usecase.MyFootballUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(private val myFootballUseCase: MyFootballUseCase) : ViewModel() {
    fun standingLeague(leagueId: String, season: String) = myFootballUseCase.getStandingLeague(leagueId, season).asLiveData()
}