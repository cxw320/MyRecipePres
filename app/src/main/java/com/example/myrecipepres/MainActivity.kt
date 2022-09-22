package com.example.myrecipepres

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.myrecipepres.api.SpoonacularApi
import com.example.myrecipepres.api.responsemodel.RecipeResponse
import com.example.myrecipepres.model.Recipe
import com.example.myrecipepres.screens.recipediscovery.RecipeDiscoveryScreen
import com.example.myrecipepres.screens.recipediscovery.RecipeDiscoveryViewModel
import com.example.myrecipepres.ui.theme.MyRecipePresTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recipeDiscoveryViewModel: RecipeDiscoveryViewModel by viewModels()

        setContent {
            MyRecipePresTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val recipeDiscoveryState =
                        recipeDiscoveryViewModel.recipeDiscoveryScreenStateFlow.collectAsState()

                    RecipeDiscoveryScreen(
                        recipeDiscoveryScreenState = recipeDiscoveryState.value,
                        onRecipeClick = {})
                }
            }
        }
    }

}

