package com.example.demorecyckerview

import android.app.Application

class App : Application() {
    val users: MutableList<User> = mutableListOf()
}