package com.example.myrecipepres.api.interceptors

import android.util.Base64
import com.example.myrecipepres.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class SpoonacularInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = BuildConfig.SPOONACULAR_API_KEY
        val url = chain.request().url.newBuilder().addQueryParameter("apiKey",apiKey).build()
        val newRequest = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(newRequest)

    }
}