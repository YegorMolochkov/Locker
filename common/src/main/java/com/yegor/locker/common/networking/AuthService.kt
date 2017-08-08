package com.yegor.locker.common.networking

import com.yegor.locker.common.model.TokenResponse
import retrofit2.http.GET
import rx.Observable

/**
 * Contains server API methods
 */
interface AuthService {

    //TODO change to real method
    @GET("qv261")
    fun login(): Observable<TokenResponse>
}