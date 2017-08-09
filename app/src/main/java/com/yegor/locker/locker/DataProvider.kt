package com.yegor.locker.locker

import android.preference.PreferenceManager

private val TOKEN_KEY = "TOKEN_KEY"

/**
 * stores token for this car
 *
 * @param token token
 */
fun setToken(token: String) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    preferences.edit().putString(TOKEN_KEY, token).apply()
}

/**
 * get stored token for this car
 */
fun getToken(): String {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    return preferences.getString(TOKEN_KEY, "")
}