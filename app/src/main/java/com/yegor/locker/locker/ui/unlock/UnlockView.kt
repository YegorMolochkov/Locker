package com.yegor.locker.locker.ui.unlock

import android.nfc.NfcAdapter

/**
 * Created by Yegor on 07.08.2017.
 */
interface UnlockView {

    fun showNoNfc()

    fun goToNfcSettings()

    fun getNfcAdapter(): NfcAdapter?

    fun registerCallback(adapter: NfcAdapter, callback: NfcAdapter.CreateNdefMessageCallback)
}