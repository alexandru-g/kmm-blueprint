package com.sv.kmmblueprint.android

import android.app.Application
import com.sv.kmmblueprint.db.DriverFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DriverFactory.context = this
    }
}