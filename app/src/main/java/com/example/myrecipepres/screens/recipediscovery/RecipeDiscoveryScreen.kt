package com.example.myrecipepres.screens.recipediscovery

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.myrecipepres.R
import com.example.myrecipepres.model.Recipe

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeDiscoveryScreen(
   viewModel : RecipeDiscoveryViewModel = viewModel()
) {
    Column {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(5.dp),
            cells = GridCells.Fixed(2)
        ) {
            items(viewModel.recipeList.value) { recipe ->
                RecipeCard(
                    recipe = recipe
                )
            }
        }
    }
}

@Composable
fun RecipeCard(
    recipe: Recipe
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .height(180.dp)
                .width(180.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            model = recipe.imageUrl,
            placeholder = painterResource(R.drawable.recipe_card_placeholder),
            contentDescription = "placeholder content description",
        )
        Text(
            text = recipe.title
        )
    }
}
