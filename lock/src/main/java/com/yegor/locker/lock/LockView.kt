package com.yegor.locker.lock

/**
 * Created by Yegor on 09.08.2017.
 */
interface LockView {

    fun onInvalidToken()

    fun setOpenView()

    fun setCloseView()
}