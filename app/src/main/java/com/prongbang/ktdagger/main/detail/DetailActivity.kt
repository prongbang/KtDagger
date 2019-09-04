package com.prongbang.ktdagger.main.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.prongbang.ktdagger.R

class DetailActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail)

		initView()

		Log.i("DetailActivity", "onCreate")
	}

	override fun onResume() {
		super.onResume()
		Log.i("DetailActivity", "onResume")
	}

	private fun initView() {
		val feed = intent.getStringExtra("ITEM_FEED")

		supportFragmentManager.beginTransaction()
				.apply {
					replace(R.id.container, DetailFragment.newInstance(feed))
					commit()
				}

	}
}
