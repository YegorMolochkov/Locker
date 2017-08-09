package com.yegor.locker.locker.ui.unlock

import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.NfcAdapter
import android.nfc.NfcEvent
import com.yegor.locker.locker.getToken

/**
 * Presenter for lock controls screen
 */
class UnlockPresenter(val unlockView: UnlockView) : NfcAdapter.CreateNdefMessageCallback {

    /**
     * on button pressed
     */
    fun changeStatus() {
        val mAdapter = unlockView.getNfcAdapter()
        if (mAdapter == null) {
            unlockView.showNoNfc()
            return
        }
        if (!mAdapter.isEnabled) {
            unlockView.goToNfcSettings()
        }
        unlockView.registerCallback(mAdapter, this)
    }

    override fun createNdefMessage(p0: NfcEvent?): NdefMessage {
        val token = getToken()
        val array = token.toByteArray()
        val ndefRecord = NdefRecord.createMime("text/plain", array)
        return NdefMessage(ndefRecord)
    }
}