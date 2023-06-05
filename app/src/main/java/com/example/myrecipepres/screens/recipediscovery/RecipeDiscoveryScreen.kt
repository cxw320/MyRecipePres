package com.example.myrecipepres.screens.recipediscovery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myrecipepres.R
import com.example.myrecipepres.model.Recipe

data class RecipeDiscoveryScreenState(
    val recipeList: List<Recipe> = listOf(
        Recipe(
            id = 1,
            title = "My Recipe",
            imageUrl = "http://www.foodista.com/recipe/MMSZLRHM/pork-chops-with-garlic-cream",
            summary = "A Recipe"
        )
    )
)

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
            columns = GridCells.Fixed(2)
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

@Composable
fun RecipeCard(
    recipe: Recipe,
    onRecipeClick: (recipeId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .height(230.dp)
            .padding(5.dp)
            .clickable {
                onRecipeClick(recipe.id.toString())
            }
    ) {
        AsyncImage(
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            model = recipe.imageUrl,
            placeholder = painterResource(R.drawable.food_pic),
            contentDescription = "test",
        )

        //TODO: Add Recipe Title using a Text composable
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    Column(
        modifier = Modifier.width(200.dp)
    ) {
        RecipeCard(
            recipe =
            Recipe(
                id = 1,
                title = "My Recipe",
                imageUrl = "",
                summary = "A Recipe"
            ),
            onRecipeClick = {}
        )
    }
}

//TODO: Add more Recipe objects to the list of Recipes to show full screen

@Preview(showBackground = true)
@Composable
fun FullScreenPreview() {
    RecipeDiscoveryScreen(
        recipeDiscoveryScreenState = RecipeDiscoveryScreenState(
            recipeList = listOf(
                Recipe(
                    id = 1,
                    title = "My Recipe",
                    imageUrl = "",
                    summary = "A Recipe"
                )
            )
        ),
        onRecipeClick = {}
    )
}


