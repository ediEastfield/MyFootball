package com.dicoding.myfootball.core.domain.usecase

import com.dicoding.myfootball.core.domain.repository.IMyFootballRepository
import javax.inject.Inject


class MyFootballInteractor @Inject constructor(private val myFootballRepository: IMyFootballRepository) : MyFootballUseCase {

    override fun getAllLeague() = myFootballRepository.getAllLeague()
    override fun getStandingLeague(leagueId: String, season: String) = myFootballRepository.getStandingLeague(leagueId, season)
    override fun getMatchResult(leagueId: String) = myFootballRepository.getMatchResult(leagueId)
}

