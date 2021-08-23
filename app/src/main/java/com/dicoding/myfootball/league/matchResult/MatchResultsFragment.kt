package com.dicoding.myfootball.league.matchResult

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
import com.dicoding.myfootball.core.ui.MatchResultAdapter
import com.dicoding.myfootball.databinding.FragmentMatchResultsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchResultsFragment(private val leagueId: String) : Fragment() {

    private val matchResultsViewModel: MatchResultsViewModel by viewModels()

    private var _binding: FragmentMatchResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val matchResultsAdapter = MatchResultAdapter()
            matchResultsAdapter.onItemClick = { selectedData ->
                Toast.makeText(requireContext(), "$selectedData", Toast.LENGTH_SHORT).show()
            }

            matchResultsViewModel.matchResults(leagueId).observe(viewLifecycleOwner, { matchResults ->
                if (matchResults != null) {
                    when (matchResults) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            matchResultsAdapter.setData(matchResults.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = matchResults.message ?: getString((R.string.something_wrong))
                        }
                    }
                }
            })

            with(binding.rvMatchResults) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = matchResultsAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}