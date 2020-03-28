package xyz.android.picker.presentation.di.module

import dagger.Binds
import dagger.Module
import xyz.android.picker.data.repository.MediaRepositoryImpl
import xyz.android.picker.domain.repository.MediaRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun mediaRepository(repository: MediaRepositoryImpl): MediaRepository
}