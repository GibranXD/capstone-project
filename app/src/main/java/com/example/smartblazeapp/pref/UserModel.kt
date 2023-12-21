package com.example.smartblazeapp.pref

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)