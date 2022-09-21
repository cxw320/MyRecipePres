package com.example.myrecipepres.repository

import android.content.Context
import com.example.myrecipepres.api.SpoonacularApi
import com.example.myrecipepres.api.responsemodel.RecipeResponse
import com.example.myrecipepres.model.Recipe

class RecipeRepository(private val context: Context) {

    suspend fun getRandomRecipes(): List<Recipe> {
         return SpoonacularApi.apiService.getRandomRecipes().body()?.recipes?.map {
            mapToRecipeModel(it)
        } ?: listOf(Recipe())
    }

    fun mapToRecipeModel(response: RecipeResponse): Recipe {
        return Recipe(
            id = response.id,
            title = response.title,
            imageUrl = response.imageUrl
        )
    }

    companion object {
        private var INSTANCE: RecipeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = RecipeRepository(context)
            }
        }

        fun get() : RecipeRepository {
            return INSTANCE ?: throw IllegalStateException("")
        }
    }
}