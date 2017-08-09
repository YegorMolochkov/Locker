package com.yegor.locker.lock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lock.*

class LockActivity : AppCompatActivity(), LockView {

    private lateinit var mPresenter: LockPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)
        mPresenter = LockPresenter(this)
        mPresenter.init()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onIntent(intent)
    }

    override fun onInvalidToken() {
        Toast.makeText(this, "Access Denied!", Toast.LENGTH_LONG).show()
    }

    override fun setCloseView() {
        status.setImageResource(R.drawable.ic_lock_black_48dp)
    }

    override fun setOpenView() {
        status.setImageResource(R.drawable.ic_lock_open_black_48dp)
    }
}
