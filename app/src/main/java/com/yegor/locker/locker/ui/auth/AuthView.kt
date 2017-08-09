package com.yegor.locker.locker.ui.auth

import com.yegor.locker.locker.ui.LoadingView

/**
 * Represents login screen
 */
interface AuthView : LoadingView {

    /**
     * on successful login
     */
    fun onLockerScreen()

    /**
     * on login failed
     */
    fun showAuthError()
}