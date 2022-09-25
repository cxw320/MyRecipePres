package com.example.myrecipepres.screens.recipediscovery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
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

@Composable
fun RecipeCard(
    recipe: Recipe,
    onRecipeClick: (recipeId: String) -> Unit
) {
    Column(
        modifier = Modifier
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
            placeholder = painterResource(R.drawable.recipe_card_placeholder),
            contentDescription = "test",
        )

        Text(
            text = recipe.title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    Column(
        modifier = Modifier.width(200.dp)
    ) {
        RecipeCard(
            recipe = Recipe(
                id = 1,
                title = "Super Soft Cinnamon Rolls",
                imageUrl = "",
                summary = ""
            ),
            onRecipeClick = {}
        )
    }
}

