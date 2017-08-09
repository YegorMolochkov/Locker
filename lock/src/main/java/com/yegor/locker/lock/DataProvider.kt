package com.yegor.locker.lock

import android.preference.PreferenceManager
import com.yegor.locker.common.ApplicationSingleton

/**
 * Created by Yegor on 07.08.2017.
 */

/**
 * this value should be took from device somehow and stored on back-end
 */
val UNIQUE_DEVICE_TOKEN: String = "token_token_token"

private val STATUS_KEY = "STATUS_KEY"

fun setStatus(status: Boolean) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    preferences.edit().putBoolean(STATUS_KEY, status).apply()
}

fun getStatus(): Boolean {
    val preferences = PreferenceManager.getDefaultSharedPreferences(ApplicationSingleton.instance)
    return preferences.getBoolean(STATUS_KEY, false)
}