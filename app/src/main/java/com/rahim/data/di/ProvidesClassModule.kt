package com.rahim.data.di

import android.app.Application
import com.rahim.data.notification.NotificationManager
import com.rahim.yadino.base.sharedPreferences.SharedPreferencesCustom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class ProvidesClassModule {
    @Provides
    fun provideNotificationManager(): NotificationManager {
        return NotificationManager()
    }
    @Provides
    fun provideSharedPreferencesCustom(application: Application): com.rahim.yadino.base.sharedPreferences.SharedPreferencesCustom {
        return com.rahim.yadino.base.sharedPreferences.SharedPreferencesCustom(application)
    }
}