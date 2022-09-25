package com.example.myrecipepres.screens.recipediscovery

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import com.example.myrecipepres.R

// To make our recipe card look nice, we still need to:
// 1: stack image and text vertically
// 2: size, crop, round image
// 3: add padding

@Composable
fun RecipeCardDemo() {
    Image(
        painter = painterResource(id = R.drawable.recipe_card_placeholder),
        contentDescription = "Image of cinnamon rolls covered in icing"
    )

    Text(
        text = "Super Soft Cinnamon Rolls"
    )
}

@Preview(showBackground = true)
@Composable
fun RecipeCardDemoPreview() {
    RecipeCardDemo()
}


