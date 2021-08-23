package com.dicoding.myfootball.league.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dicoding.myfootball.core.domain.model.League
import com.dicoding.myfootball.databinding.FragmentLeagueHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeagueHistoryFragment(private val league: League?) : Fragment() {

    private var _binding: FragmentLeagueHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeagueHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            showDetailLeague(league)
        }
    }

    private fun showDetailLeague(league: League?) {
        league?.let {
            binding.tvLeagueName.text = league.league
            Glide.with(this)
                .load(league.badge)
                .into(binding.ivLeagueBadge)
            binding.tvLeagueDescription.text = league.description
            Glide.with(this)
                .load(league.trophy)
                .into(binding.ivLeagueTrophy)
            Glide.with(this)
                .load(league.fanArt)
                .into(binding.ivLeagueFanArt)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}