package com.dicoding.myfootball.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.myfootball.core.data.source.local.room.MyFootballDao
import com.dicoding.myfootball.core.data.source.local.room.MyFootballDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MyFootballDatabase = Room.databaseBuilder(
        context,
        MyFootballDatabase::class.java,
        "MyFootball.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMyFootballDao(database: MyFootballDatabase): MyFootballDao = database.myFootballDao()
}