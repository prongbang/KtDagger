package com.prongbang.ktdagger.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prongbang.ktdagger.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_detail, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initView()
	}

	private fun initView() {
		val feed = arguments?.getString("ITEM_FEED")
		view.apply {
			textView.text = feed
		}
	}

	companion object {
		fun newInstance(feed: String): DetailFragment {
			return DetailFragment().apply {
				arguments = Bundle().apply {
					putString("ITEM_FEED", feed)
				}
			}
		}
	}
}
