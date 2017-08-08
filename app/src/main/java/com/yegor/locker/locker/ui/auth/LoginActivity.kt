package com.yegor.locker.locker.ui.auth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.yegor.locker.common.model.Credentials
import com.yegor.locker.locker.R
import com.yegor.locker.locker.ui.unlock.UnlockActivity
import kotlinx.android.synthetic.main.activity_login.*
import ru.arturvasilov.rxloader.LoaderLifecycleHandler

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), AuthView {

    private lateinit var mPresenter: AuthPresenter

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun onLockerScreen() {
        startActivity(Intent(this, UnlockActivity::class.java))
    }

    override fun hideLoading() {
        progress.visibility = View.INVISIBLE
    }

    override fun showAuthError() {
        Toast.makeText(this, "Login failed!", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initPresenter()
        submit.setOnClickListener { mPresenter.tryToLogin(Credentials(username.text.toString(), password.text.toString())) }
    }

    private fun initPresenter() {
        val lifecycleHandler = LoaderLifecycleHandler.create(this, supportLoaderManager)
        mPresenter = AuthPresenter(this, lifecycleHandler)
        mPresenter.init()
    }
}
