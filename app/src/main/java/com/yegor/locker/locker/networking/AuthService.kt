package com.yegor.locker.locker.networking

import com.yegor.locker.locker.model.TokenResponse
import retrofit2.http.GET
import rx.Observable

/**
 * Contains server API methods
 */
interface AuthService {

    //TODO change to real method, should take car serial number and password as params
    @GET("qv261")
    fun login(/*sn : String, password : String*/): Observable<TokenResponse>
}