package com.example.myrecipepres

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myrecipepres.model.Recipe
import com.example.myrecipepres.screens.recipediscovery.RecipeDiscoveryScreen
import com.example.myrecipepres.screens.recipediscovery.RecipeDiscoveryScreenState
import com.example.myrecipepres.ui.theme.MyRecipePresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRecipePresTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //RecipeDiscoveryScreen()
                }
            }
        }
    }
}

