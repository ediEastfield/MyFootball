package com.dicoding.myfootball.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.myfootball.core.data.source.local.entity.EventEntity
import com.dicoding.myfootball.core.data.source.local.entity.LeagueEntity
import com.dicoding.myfootball.core.data.source.local.entity.StandingEntity

@Database(
    entities = [
        LeagueEntity::class,
        StandingEntity::class,
        EventEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class MyFootballDatabase : RoomDatabase() {

    abstract fun myFootballDao(): MyFootballDao

}