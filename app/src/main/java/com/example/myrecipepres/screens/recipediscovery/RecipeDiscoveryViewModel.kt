package com.example.myrecipepres.screens.recipediscovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipepres.model.Recipe
import com.example.myrecipepres.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeDiscoveryViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository.get()

    private var recipeList = emptyList<Recipe>()
    
    init{
        viewModelScope.launch{
            recipeList = recipeRepository.getRandomRecipes()
        }
    }

}