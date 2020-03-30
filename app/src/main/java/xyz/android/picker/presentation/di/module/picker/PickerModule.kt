package xyz.android.picker.presentation.di.module.picker

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import xyz.android.picker.presentation.di.ViewModelKey
import xyz.android.picker.presentation.ui.PickerFragment
import xyz.android.picker.presentation.ui.PickerPreviewFragment
import xyz.android.picker.presentation.ui.PickerViewModel

@Module
abstract class PickerModule {

    @Binds
    @IntoMap
    @ViewModelKey(PickerViewModel::class)
    abstract fun pickerViewModel(viewModel: PickerViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun pickerPreviewFragment(): PickerPreviewFragment

    @ContributesAndroidInjector
    abstract fun pickerFragment(): PickerFragment
}