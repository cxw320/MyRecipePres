package com.example.myrecipepres

import android.app.Application
import com.example.myrecipepres.repository.RecipeRepository

class MyRecipeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RecipeRepository.initialize(context = this)
    }

}