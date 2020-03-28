package xyz.android.picker.presentation.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import xyz.android.picker.presentation.di.module.ActivityBindingModule
import xyz.android.picker.presentation.di.module.AppModule
import xyz.android.picker.presentation.di.module.DataSourceModule
import xyz.android.picker.presentation.di.module.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        DataSourceModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: DaggerApplication): Builder

        fun build(): AppComponent
    }
}