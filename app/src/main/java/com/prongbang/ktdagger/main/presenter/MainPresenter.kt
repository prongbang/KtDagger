package com.prongbang.ktdagger.main.presenter

import javax.inject.Inject

class MainPresenter @Inject constructor(
		private val view: MainContract.View,
		private val viewModel: MainViewModel
) : MainContract.UserActionListener {

	override fun getFeed() {
		view.showFeed(viewModel.getFeed())
	}

}