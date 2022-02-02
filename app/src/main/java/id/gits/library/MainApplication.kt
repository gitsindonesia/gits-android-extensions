package id.gits.library

import android.app.Application
import id.gits.library.di.AppComponent
import id.gits.library.di.DaggerAppComponent

class MainApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}