package com.prongbang.ktdagger.di

import com.prongbang.ktdagger.main.MainContributor
import dagger.Module

@Module(includes = [
	MainContributor::class
])
class ContributorModule