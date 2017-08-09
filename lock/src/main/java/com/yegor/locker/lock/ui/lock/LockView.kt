package com.yegor.locker.lock.ui.lock

/**
 * interface for lock screen
 */
interface LockView {

    /**
     * call on invalid token income
     */
    fun onInvalidToken()

    /**
     * calls to open lock ui
     */
    fun setOpenView()

    /**
     * calls to close lock ui
     */
    fun setCloseView()
}