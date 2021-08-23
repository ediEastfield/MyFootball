package com.dicoding.myfootball.league

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.dicoding.myfootball.R
import com.dicoding.myfootball.core.domain.model.League
import com.dicoding.myfootball.databinding.ActivityLeagueBinding
import com.dicoding.myfootball.league.history.LeagueHistoryFragment
import com.dicoding.myfootball.league.matchResult.MatchResultsFragment
import com.dicoding.myfootball.league.standing.StandingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val EXTRA_LEAGUE = "extra_league"
    }

    private lateinit var binding: ActivityLeagueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val league = intent.getParcelableExtra<League>(EXTRA_LEAGUE)

        supportActionBar?.title = league?.league

        binding.navView.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, LeagueHistoryFragment(league))
                .commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        val league = intent.getParcelableExtra<League>(EXTRA_LEAGUE)
        when (item.itemId) {
            R.id.nav_league -> {
                fragment = LeagueHistoryFragment(league)
            }
            R.id.nav_standings -> {
                fragment = StandingsFragment(league?.leagueId, league?.currentSeason)
            }
            R.id.nav_match_results -> {
                fragment = MatchResultsFragment(league!!.leagueId)
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}