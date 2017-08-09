package com.yegor.locker.locker.ui.unlock

import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.yegor.locker.locker.R
import kotlinx.android.synthetic.main.activity_unlock.*

/**
 * Created by Yegor on 07.08.2017.
 */
class UnlockActivity : AppCompatActivity(), UnlockView {

    private lateinit var mPresenter: UnlockPresenter

    override fun showNoNfc() {
        Toast.makeText(this, "Sorry this device does not have NFC.", Toast.LENGTH_LONG).show()
    }

    override fun goToNfcSettings() {
        Toast.makeText(this, "Please, enable NFC.", Toast.LENGTH_LONG).show()
        startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS));
    }

    override fun getNfcAdapter(): NfcAdapter? {
        return NfcAdapter.getDefaultAdapter(this)
    }

    override fun registerCallback(adapter: NfcAdapter, callback: NfcAdapter.CreateNdefMessageCallback) {
        adapter.setNdefPushMessageCallback(callback, this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unlock)
        mPresenter = UnlockPresenter(this)
        unlock.setOnClickListener { view -> mPresenter.changeStatus() }
    }
}