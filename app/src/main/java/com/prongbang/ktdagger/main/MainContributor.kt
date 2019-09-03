package com.prongbang.ktdagger.main

import com.prongbang.ktdagger.main.presenter.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainContributor {
	@ContributesAndroidInjector(modules = [MainModule::class])
	abstract fun contribute(): MainActivity
}