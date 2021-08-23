package com.dicoding.myfootball.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.myfootball.R
import com.dicoding.myfootball.core.domain.model.League
import com.dicoding.myfootball.databinding.ItemListLeagueBinding

class LeagueAdapter : RecyclerView.Adapter<LeagueAdapter.ListViewHolder>() {

    private var listData = ArrayList<League>()
    var onItemClick: ((League) -> Unit)? = null

    fun setData(newListData: List<League>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int) =
        ListViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_league, viewGroup, false))

    override fun onBindViewHolder(listViewHolder: ListViewHolder, position: Int) {
        val data = listData[position]
        listViewHolder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListLeagueBinding.bind(itemView)
        fun bind(data: League) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.badge)
                    .into(ivBadgeLeague)
                tvItemTitle.text = data.league
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}