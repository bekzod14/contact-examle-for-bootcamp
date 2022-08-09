package uz.gita.contactexample

import android.app.Application
import timber.log.Timber
import uz.gita.contactexample.data.room.AppDatabase


// Created by Jamshid Isoqov an 8/9/2022
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        AppDatabase.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}