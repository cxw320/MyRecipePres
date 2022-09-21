package com.example.myrecipepres

import android.app.Application

class MyRecipeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //Repository.initialize(context = this)
    }

}