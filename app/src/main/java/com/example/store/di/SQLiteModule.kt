package com.example.store.di

import com.example.store.data.database.DBHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SQLiteModule {

    @Provides
    @Singleton
    fun provideDatabase(database: DBHelper) : DBHelper {
        return database
    }
}