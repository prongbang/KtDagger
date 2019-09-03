package com.prongbang.ktdagger.main.presenter

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

	fun getFeed(): List<String> {
		return listOf(
				"Feed 1",
				"Feed 2",
				"Feed 3",
				"Feed 4",
				"Feed 5",
				"Feed 6"
		)
	}

}