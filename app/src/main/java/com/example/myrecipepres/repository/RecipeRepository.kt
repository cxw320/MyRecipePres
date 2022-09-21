package com.example.myrecipepres.repository

import com.example.myrecipepres.api.SpoonacularApi
import com.example.myrecipepres.api.responsemodel.RecipeResponse
import com.example.myrecipepres.model.Recipe


class RecipeRepository {

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
}