package com.prongbang.ktdagger

import com.prongbang.ktdagger.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApplication : DaggerApplication() {

	override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
		return DaggerAppComponent.builder()
				.application(this)
				.create(this)
	}

}