package com.dicoding.myfootball.core.utils

import com.dicoding.myfootball.core.data.source.local.entity.EventEntity
import com.dicoding.myfootball.core.data.source.local.entity.LeagueEntity
import com.dicoding.myfootball.core.data.source.local.entity.StandingEntity
import com.dicoding.myfootball.core.data.source.remote.response.EventResponse
import com.dicoding.myfootball.core.data.source.remote.response.LeagueResponse
import com.dicoding.myfootball.core.data.source.remote.response.StandingResponse
import com.dicoding.myfootball.core.domain.model.Event
import com.dicoding.myfootball.core.domain.model.League
import com.dicoding.myfootball.core.domain.model.Standing

object DataMapper {

    fun mapLeagueEntitiesToDomain(input: List<LeagueEntity>): List<League> =
        input.map {
            League(
                leagueId = it.leagueId,
                league = it.league,
                badge = it.badge,
                description = it.description,
                trophy = it.trophy,
                fanArt = it.fanArt,
                currentSeason = it.currentSeason
            )
        }

    fun mapStandingEntitiesToDomain(input: List<StandingEntity>): List<Standing> =
        input.map {
            Standing(
                standingId = it.standingId,
                leagueId = it.leagueId,
                rank = it.rank,
                teamId = it.teamId,
                badgeTeam = it.badgeTeam,
                team = it.team,
                played = it.played,
                win = it.win,
                draw = it.draw,
                lost = it.lost,
                goalsFor = it.goalsFor,
                goalsAgainst = it.goalsAgainst,
                goalDifference = it.goalDifference,
                points = it.points
            )
        }

    fun mapEventEntitiesToDomain(input: List<EventEntity>): List<Event> =
        input.map {
            Event(
                eventId = it.eventId,
                event = it.event,
                leagueId = it.leagueId,
                league = it.league,
                season = it.season,
                description = it.description,
                homeTeam = it.homeTeam,
                awayTeam = it.awayTeam,
                homeScore = it.homeScore,
                round = it.round,
                awayScore = it.awayScore,
                dateEvent = it.dateEvent,
                homeTeamId = it.homeTeamId,
                awayTeamId = it.awayTeamId,
                venue = it.venue,
                thumb = it.thumb,
                status = it.status,
                video = it.video
            )
        }

    fun mapLeagueResponseToEntities(input: List<LeagueResponse>): List<LeagueEntity> {
        val leagueList = ArrayList<LeagueEntity>()
        input.map {
            val league = LeagueEntity(
                leagueId = it.leagueId,
                league = it.league,
                badge = it.badge,
                description = it.description,
                trophy = it.trophy,
                fanArt = it.fanArt,
                currentSeason = it.currentSeason
            )
            leagueList.add(league)
        }
        return leagueList
    }

    fun mapStandingResponsesToEntities(input: List<StandingResponse>): List<StandingEntity> {
        val standingLeagueList = ArrayList<StandingEntity>()
        input.map {
            val standingLeague = StandingEntity(
                standingId = it.standingId,
                leagueId = it.leagueId,
                rank = it.rank,
                teamId = it.teamId,
                badgeTeam = it.badgeTeam,
                team = it.team,
                played = it.played,
                win = it.win,
                draw = it.draw,
                lost = it.lost,
                goalsFor = it.goalsFor,
                goalsAgainst = it.goalsAgainst,
                goalDifference = it.goalDifference,
                points = it.points
            )
            standingLeagueList.add(standingLeague)
        }
        return standingLeagueList
    }

    fun mapEventResponsesToEntities(input: List<EventResponse>): List<EventEntity> {
        val eventList = ArrayList<EventEntity>()
        input.map {
            val event = EventEntity(
                eventId = it.eventId,
                event = it.event,
                leagueId = it.leagueId,
                league = it.league,
                season = it.season,
                description = it.description,
                homeTeam = it.homeTeam,
                awayTeam = it.awayTeam,
                homeScore = it.homeScore,
                round = it.round,
                awayScore = it.awayScore,
                dateEvent = it.dateEvent,
                homeTeamId = it.homeTeamId,
                awayTeamId = it.awayTeamId,
                venue = it.venue,
                thumb = it.thumb,
                status = it.status,
                video = it.video
            )
            eventList.add(event)
        }
        return eventList
    }

}