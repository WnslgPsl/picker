package xyz.android.picker.presentation.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import xyz.android.picker.presentation.di.ViewModelFactory

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}