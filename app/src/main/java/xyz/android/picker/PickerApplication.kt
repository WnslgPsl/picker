package xyz.android.picker

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import xyz.android.picker.presentation.di.DaggerAppComponent

class PickerApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}