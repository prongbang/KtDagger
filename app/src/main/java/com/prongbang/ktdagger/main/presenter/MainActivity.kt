package com.prongbang.ktdagger.main.presenter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.prongbang.ktdagger.R
import com.prongbang.ktdagger.main.detail.DetailActivity
import com.prongbang.ktdagger.main.presenter.list.MainAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainContract.View {

	@Inject
	lateinit var presenter: MainContract.UserActionListener

	@Inject
	lateinit var mainAdapter: MainAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		Log.v("MainActivity", "onCreate")

		fab.setOnClickListener { view ->
			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
					.setAction("Action", null)
					.show()
		}

		initView()
		presenter.getFeed()
	}

	private fun initView() {
		rvFeed.apply {
			layoutManager = LinearLayoutManager(this@MainActivity)
			adapter = mainAdapter
		}
		mainAdapter.onItemClickListener = { feed ->
			val intent = Intent(this, DetailActivity::class.java).apply {
				putExtra("ITEM_FEED", feed)
			}
			startActivity(intent)
		}
	}

	override fun showFeed(feed: List<String>) {
		mainAdapter.submitList(feed)
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return when (item.itemId) {
			R.id.action_settings -> true
			else -> super.onOptionsItemSelected(item)
		}
	}
}
