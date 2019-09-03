package com.prongbang.ktdagger.di

import android.app.Application
import com.prongbang.ktdagger.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
	AndroidSupportInjectionModule::class,
	AppModule::class,
	ContributorModule::class
])
interface AppComponent : AndroidInjector<MainApplication> {

	@Component.Builder
	abstract class Builder : AndroidInjector.Builder<MainApplication>() {

		@BindsInstance
		abstract fun application(application: Application): Builder
	}
}