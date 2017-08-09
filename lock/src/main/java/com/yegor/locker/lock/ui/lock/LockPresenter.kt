package com.yegor.locker.lock.ui.lock

import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import com.yegor.locker.lock.UNIQUE_DEVICE_TOKEN
import com.yegor.locker.lock.getStatus
import com.yegor.locker.lock.setStatus

/**
 * Presenter for lock screen
 */
class LockPresenter(val lockView: LockView) {

    /**
     * initiates UI
     */
    fun init() {
        setNewStatusUi(getStatus())
    }

    /**
     * processes new intent
     *
     * @param intent new intent
     */
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