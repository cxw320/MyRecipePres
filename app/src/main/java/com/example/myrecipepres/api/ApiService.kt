package com.example.myrecipepres.api

import com.example.myrecipepres.api.interceptors.SpoonacularInterceptor
import com.example.myrecipepres.api.responsemodel.RecipeListResponse
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("random?number=20")
    suspend fun getRandomRecipes(): Response<RecipeListResponse>

}

val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(SpoonacularInterceptor())
    .build()



private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.spoonacular.com/recipes/")
        .client(client)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().build()
            )
        )
    .build()

object SpoonacularApi {
    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
