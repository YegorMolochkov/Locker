package com.yegor.locker.locker.ui

/**
 * represents any loading screen
 */
interface LoadingView {

    /**
     * shows loading dialog
     */
    fun showLoading()

    /**
     * hides loading dialog
     */
    fun hideLoading()
}