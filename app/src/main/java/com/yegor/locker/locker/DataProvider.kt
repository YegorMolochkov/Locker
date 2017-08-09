package com.yegor.locker.locker

import android.preference.PreferenceManager
import com.yegor.locker.common.ApplicationSingleton

/**
 * Created by Yegor on 07.08.2017.
 */
private val TOKEN_KEY = "TOKEN_KEY"

fun getUsername(): String {
    return "username"
}

fun getPassword(): String {
    return "password"
}

fun setToken(token: String) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    preferences.edit().putString(TOKEN_KEY, token).apply()
}

fun getToken(): String {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    return preferences.getString(TOKEN_KEY, "")
}