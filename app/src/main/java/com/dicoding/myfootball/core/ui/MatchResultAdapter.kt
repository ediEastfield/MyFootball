package com.dicoding.myfootball.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.myfootball.R
import com.dicoding.myfootball.core.domain.model.Event
import com.dicoding.myfootball.databinding.ItemListMatchResultsBinding

class MatchResultAdapter : RecyclerView.Adapter<MatchResultAdapter.ListViewHolder>() {

    private var listData = ArrayList<Event>()
    var onItemClick: ((Event) -> Unit)? = null

    fun setData(newListData: List<Event>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_match_results, parent, false))

    override fun onBindViewHolder(holder: MatchResultAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMatchResultsBinding.bind(itemView)
        fun bind(data: Event) {
            with(binding) {
                tvDateMatch.text = data.dateEvent
                tvHomeTeam.text = data.homeTeam
                tvHomeScore.text = data.homeScore
                tvAwayTeam.text = data.awayTeam
                tvAwayScore.text = data.awayScore
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[bindingAdapterPosition])
            }
        }
    }
}