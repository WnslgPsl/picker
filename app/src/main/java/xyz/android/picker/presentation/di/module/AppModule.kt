package xyz.android.picker.presentation.di.module

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.DaggerApplication

@Module
interface AppModule {

    @Binds
    fun bindContext(application: DaggerApplication): Context
}