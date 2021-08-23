package com.dicoding.myfootball.league.standing

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.myfootball.R
import com.dicoding.myfootball.core.data.Resource
import com.dicoding.myfootball.core.ui.StandingAdapter
import com.dicoding.myfootball.databinding.FragmentStandingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StandingsFragment(private val leagueId: String?, private val season: String?) : Fragment() {

    private val standingsViewModel: StandingsViewModel by viewModels()

    private var _binding: FragmentStandingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStandingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val standingAdapter = StandingAdapter()
            standingAdapter.onItemClick = { selectedData ->
                Toast.makeText(requireContext(), "$selectedData", Toast.LENGTH_SHORT).show()
            }

            standingsViewModel.standingLeague(leagueId!!, season!!).observe(viewLifecycleOwner, { standings ->
                if (standings != null) {
                    when (standings) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            standingAdapter.setData(standings.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = standings.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvStandings) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = standingAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}