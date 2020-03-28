package xyz.android.picker.presentation.di.module

import dagger.Binds
import dagger.Module
import xyz.android.picker.data.provider.MediaProvider
import xyz.android.picker.data.provider.MediaProviderImpl

@Module
abstract class MediaProviderModule {

    @Binds
    abstract fun mediaProvider(mediaProvider: MediaProviderImpl): MediaProvider
}