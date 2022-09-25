package com.example.myrecipepres.screens.recipediscovery

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipepres.model.Recipe
import com.example.myrecipepres.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeDiscoveryViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository.get()

    var recipeList = mutableStateOf<List<Recipe>>(listOf())

    init{
        viewModelScope.launch{
            recipeList.value = recipeRepository.getRandomRecipes()
        }
    }
}