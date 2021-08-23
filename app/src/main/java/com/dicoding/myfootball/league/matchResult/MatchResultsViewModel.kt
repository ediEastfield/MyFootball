package com.dicoding.myfootball.league.matchResult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.myfootball.core.domain.usecase.MyFootballUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchResultsViewModel @Inject constructor(private val myFootballUseCase: MyFootballUseCase) : ViewModel() {
    fun matchResults(leagueId: String) = myFootballUseCase.getMatchResult(leagueId).asLiveData()
}