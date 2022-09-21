package com.example.myrecipepres.api.interceptors

import android.util.Base64
import com.example.myrecipepres.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class SpoonacularInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = BuildConfig.SPOONACULAR_API_KEY
        val encodedApiKey =
            Base64.encodeToString(apiKey.toByteArray(Charsets.UTF_8), Base64.NO_WRAP)
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Basic $encodedApiKey")
            .build()
        return chain.proceed(newRequest)

    }
}