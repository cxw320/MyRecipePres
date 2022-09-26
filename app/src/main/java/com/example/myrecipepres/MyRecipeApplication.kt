package com.example.myrecipepres

import com.example.myrecipepres.repository.RecipeRepository

import android.app.Application

class MyRecipeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RecipeRepository.initialize(context = this)
    }

}