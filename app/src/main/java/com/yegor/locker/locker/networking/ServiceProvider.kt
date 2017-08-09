package com.yegor.locker.locker.networking

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Services factory
 */
object ServiceProvider {

    //TODO change to real endpoint
    private val sBaseURL = "https://api.myjson.com/bins/"

    /**
     * creates service of given type
     *
     * @param serviceClass service class
     * @return service instance
     */
    fun <S> createService(serviceClass: Class<S>): S {
        val okHttpClient = OkHttpClient.Builder().build()
        val gsonBuilder = GsonBuilder()
        val builder = Retrofit.Builder()
                .baseUrl(sBaseURL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        val retrofit = builder.client(okHttpClient).build()
        return retrofit.create(serviceClass)
    }
}