package com.prongbang.ktdagger.main.presenter.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prongbang.ktdagger.R
import kotlinx.android.synthetic.main.item_feed.view.*
import javax.inject.Inject

class MainAdapter @Inject constructor() :
		ListAdapter<String, MainAdapter.ViewHolder>(DIFF_COMPARATOR) {

	var onItemClickListener: (String) -> Unit = {}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(
				LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false))
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.bind(getItem(position))
	}

	inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

		fun bind(item: String) {
			view.apply {
				txtItem.text = item
				setOnClickListener {
					onItemClickListener.invoke(item)
				}
			}
		}

	}

	companion object {
		private val DIFF_COMPARATOR = object : DiffUtil.ItemCallback<String>() {
			override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
				return oldItem == newItem
			}

			override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
				return oldItem == newItem
			}

		}
	}
}