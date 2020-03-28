package xyz.android.picker.presentation.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import xyz.android.picker.presentation.di.module.picker.PickerModule
import xyz.android.picker.presentation.di.scoped.ActivityScoped
import xyz.android.picker.presentation.ui.PickerActivity
import xyz.android.picker.presentation.ui.PickerViewModel

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ViewModelFactoryModule::class, PickerModule::class])
    abstract fun pickerActivity(): PickerActivity
}