package com.example.smartblazeapp.di

import android.content.Context
import com.example.smartblazeapp.pref.UserPreference
import com.example.smartblazeapp.pref.dataStore
import com.example.smartblazeapp.repository.UserRepository
import com.example.smartblazeapp.retrofit.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {

    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return UserRepository.getInstance(apiService, pref)
    }
}