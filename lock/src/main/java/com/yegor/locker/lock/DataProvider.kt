package com.yegor.locker.lock

import android.preference.PreferenceManager

/**
 * this value should be took from device somehow and stored on back-end
 */
val UNIQUE_DEVICE_TOKEN: String = "token_token_token"

private val STATUS_KEY = "STATUS_KEY"

/**
 * sets current lock status
 *
 * @param status new lock status
 */
fun setStatus(status: Boolean) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    preferences.edit().putBoolean(STATUS_KEY, status).apply()
}

/**
 * get current lock status
 */
fun getStatus(): Boolean {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    return preferences.getBoolean(STATUS_KEY, false)
}