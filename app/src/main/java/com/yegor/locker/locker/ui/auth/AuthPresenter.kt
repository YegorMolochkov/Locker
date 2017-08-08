package com.yegor.locker.locker.ui.auth

import android.text.TextUtils
import com.yegor.locker.common.model.Credentials
import com.yegor.locker.common.networking.AuthService
import com.yegor.locker.common.networking.ServiceProvider
import com.yegor.locker.locker.*
import ru.arturvasilov.rxloader.LifecycleHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Presenter for AuthView.
 */
class AuthPresenter(val authView: AuthView, val lifecycleHandler: LifecycleHandler) {

    fun init() {
        val token = getToken()
        if (token != null) {
            authView.onLockerScreen()
        }
    }

    fun tryToLogin(credentials: Credentials) {
        if (TextUtils.isEmpty(credentials.username) || TextUtils.isEmpty(credentials.password)) {
            authView.showAuthError()
        } else {
            val service = ServiceProvider.createService(AuthService::class.java)
            service.login()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(authView::showLoading)
                    .doOnTerminate(authView::hideLoading)
                    .compose(lifecycleHandler.reload(R.id.auth_request))
                    .subscribe({
                        authView.onLockerScreen()
                        setToken(it.token)
                    }, {
                        authView.showAuthError()
                    })
        }
    }
}