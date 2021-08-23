package com.dicoding.myfootball.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.myfootball.R
import com.dicoding.myfootball.core.data.Resource
import com.dicoding.myfootball.core.ui.LeagueAdapter
import com.dicoding.myfootball.databinding.FragmentHomeBinding
import com.dicoding.myfootball.league.LeagueActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val leagueAdapter = LeagueAdapter()
            leagueAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, LeagueActivity::class.java)
                intent.putExtra(LeagueActivity.EXTRA_LEAGUE, selectedData)
                startActivity(intent)
            }

            homeViewModel.league.observe(viewLifecycleOwner, { league ->
                if (league != null) {
                    when (league) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            leagueAdapter.setData(league.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = league.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvLeague) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = leagueAdapter
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}