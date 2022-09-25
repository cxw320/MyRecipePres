package com.example.myrecipepres.screens.recipediscovery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myrecipepres.model.RecipeDiscoveryScreenState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeDiscoveryScreen(
    recipeDiscoveryScreenState: RecipeDiscoveryScreenState,
    onRecipeClick: (recipeId: String) -> Unit
) {
    Column {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(5.dp),
            cells = GridCells.Fixed(2)
        ) {
            items(recipeDiscoveryScreenState.recipeList) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onRecipeClick = onRecipeClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDiscoveryScreenPreview() {
    RecipeDiscoveryScreen(
        recipeDiscoveryScreenState = RecipeDiscoveryScreenState(),
        onRecipeClick = {}
    )
}


