package com.prongbang.ktdagger.main.presenter

import androidx.lifecycle.LifecycleObserver

interface MainContract {

	interface View {
		fun showFeed(feed: List<String>)
	}

	interface UserActionListener : LifecycleObserver {
		fun getFeed()
	}
}