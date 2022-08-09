package uz.gita.contactexample

import android.app.Application
import timber.log.Timber


// Created by Jamshid Isoqov an 8/9/2022
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}