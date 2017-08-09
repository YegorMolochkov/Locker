package com.yegor.locker.locker.ui.unlock

import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.NfcAdapter
import android.nfc.NfcEvent
import com.yegor.locker.locker.getToken

/**
 * Created by Yegor on 08.08.2017.
 */
class UnlockPresenter(val unlockView: UnlockView) : NfcAdapter.CreateNdefMessageCallback {

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