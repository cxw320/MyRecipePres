package com.example.myrecipepres.screens.recipediscovery

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipepres.model.Recipe
import com.example.myrecipepres.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeDiscoveryViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository.get()

    var recipeDiscoveryScreenState = mutableStateOf(RecipeDiscoveryScreenState())

    var recipeList = emptyList<Recipe>()

    init{
        viewModelScope.launch{
            recipeList = recipeRepository.getRandomRecipes()
            recipeDiscoveryScreenState.value = RecipeDiscoveryScreenState(recipeList = recipeList)
        }
    }
}