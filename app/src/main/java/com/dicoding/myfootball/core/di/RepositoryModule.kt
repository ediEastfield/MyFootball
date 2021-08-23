package com.dicoding.myfootball.core.di

import com.dicoding.myfootball.core.data.MyFootballRepository
import com.dicoding.myfootball.core.domain.repository.IMyFootballRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(myFootballRepository: MyFootballRepository): IMyFootballRepository
}