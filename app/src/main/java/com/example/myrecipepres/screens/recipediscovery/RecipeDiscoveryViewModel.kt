package com.example.myrecipepres.screens.recipediscovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipepres.model.Recipe
import com.example.myrecipepres.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RecipeDiscoveryViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository.get()

    val recipeDiscoveryScreenStateFlow = MutableStateFlow(RecipeDiscoveryScreenState())

    private var recipeList = emptyList<Recipe>()

    init{
        viewModelScope.launch{
            recipeList = recipeRepository.getRandomRecipes()
            recipeDiscoveryScreenStateFlow.emit(
                recipeDiscoveryScreenStateFlow.value.copy(
                    recipeList = recipeList
                )
            )
        }
    }

}