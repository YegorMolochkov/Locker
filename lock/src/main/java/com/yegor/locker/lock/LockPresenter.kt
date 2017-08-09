package com.yegor.locker.lock

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter

/**
 * Created by Yegor on 09.08.2017.
 */
class LockPresenter(val lockView: LockView) {

    fun init() {
        setNewStatusUi(getStatus())
    }

    fun onIntent(intent: Intent) {
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.getAction()) {
            val token = intentToToken(intent)
            if (!validateToken(token)) {
                lockView.onInvalidToken()
                return
            } else {
                val newStatus = !getStatus()
                setStatus(newStatus)
                setNewStatusUi(newStatus)
            }
        }
    }

    private fun setNewStatusUi(isOpen: Boolean) {
        if (isOpen) {
            lockView.setOpenView()
        } else {
            lockView.setCloseView()
        }
    }

    private fun intentToToken(intent: Intent): String {
        val rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
        val message = rawMessages[0] as NdefMessage // only one message transferred
        return String(message.records[0].payload)
    }

    private fun validateToken(token: String): Boolean {
        return token == UNIQUE_DEVICE_TOKEN
    }
}