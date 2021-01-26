package com.example.oasis.app

import android.app.Application
import com.example.oasis.utils.MyMmkv

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        MyMmkv.initMMKV()
    }

    companion object{
        var instance:MyApp? = null
    }

}