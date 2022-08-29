package com.example.myrecipepres.api

import com.example.myrecipepres.api.responsemodel.RecipeListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("random?apiKey=bcaa49c492c948dc99175ac11e8dcb66&number=20")
    suspend fun getRandomRecipes(): Response<RecipeListResponse>

}