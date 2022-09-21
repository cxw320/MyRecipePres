package com.example.myrecipepres

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.myrecipepres.api.SpoonacularApi
import com.example.myrecipepres.api.responsemodel.RecipeResponse
import com.example.myrecipepres.model.Recipe
import com.example.myrecipepres.ui.theme.MyRecipePresTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch{
            val recipeList = SpoonacularApi.apiService.getRandomRecipes().body()?.recipes?.map {
                mapToRecipeModel(it)
            } ?: listOf(Recipe())
            Log.d("Caroline","${recipeList[0]}")
        }


        setContent {
            MyRecipePresTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }

    fun mapToRecipeModel(response: RecipeResponse): Recipe {

        return Recipe(
            id = response.id,
            title = response.title,
            imageUrl = response.imageUrl
        )
    }
}

