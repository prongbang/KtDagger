package com.prongbang.ktdagger.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProviders
import com.prongbang.ktdagger.main.presenter.MainActivity
import com.prongbang.ktdagger.main.presenter.MainContract
import com.prongbang.ktdagger.main.presenter.MainPresenter
import com.prongbang.ktdagger.main.presenter.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule {

	@Provides
	fun provideView(activity: MainActivity): MainContract.View = activity

	@Provides
	fun provideLifecycle(activity: MainActivity): Lifecycle = activity.lifecycle

	@Provides
	fun provideViewModel(activity: MainActivity): MainViewModel =
			ViewModelProviders.of(activity).get(MainViewModel::class.java)

	@Provides
	fun provideMainPresenter(lifecycle: Lifecycle,
	                         presenter: MainPresenter): MainContract.UserActionListener =
			presenter.apply {
				lifecycle.addObserver(presenter)
			}
}