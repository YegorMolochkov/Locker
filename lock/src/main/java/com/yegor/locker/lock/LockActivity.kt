package com.yegor.locker.lock

import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
    }

    override fun onResume() {
        super.onResume()
        val intent = intent
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action) {
            val rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES)
            val message = rawMessages[0] as NdefMessage // only one message transferred
            Toast.makeText(this, String(message.records[0].payload), Toast.LENGTH_LONG).show()
        } else
            Toast.makeText(this, "Waiting for NDEF Message", Toast.LENGTH_LONG).show()
    }
}
