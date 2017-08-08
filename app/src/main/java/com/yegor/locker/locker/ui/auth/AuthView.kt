package com.yegor.locker.locker.ui.auth

import com.yegor.locker.common.ui.LoadingView

/**
 * Created by Yegor on 08.08.2017.
 */
interface AuthView : LoadingView {

    fun onLockerScreen()

    fun showAuthError()
}