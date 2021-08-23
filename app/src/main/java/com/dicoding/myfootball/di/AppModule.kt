package com.dicoding.myfootball.di

import com.dicoding.myfootball.core.domain.usecase.MyFootballInteractor
import com.dicoding.myfootball.core.domain.usecase.MyFootballUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMyFootballUseCase(myFootballInteractor: MyFootballInteractor): MyFootballUseCase
}