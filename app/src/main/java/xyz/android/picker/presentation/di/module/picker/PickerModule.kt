package xyz.android.picker.presentation.di.module.picker

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.android.picker.presentation.di.ViewModelKey
import xyz.android.picker.presentation.ui.PickerViewModel

@Module
abstract class PickerModule {

    @Binds
    @IntoMap
    @ViewModelKey(PickerViewModel::class)
    abstract fun pickerViewModel(viewModel: PickerViewModel): ViewModel
}