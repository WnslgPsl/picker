package xyz.android.picker.presentation.di.module.result

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.android.picker.presentation.di.ViewModelKey
import xyz.android.picker.presentation.ui.result.ResultViewModel

@Module
abstract class ResultModule {

    @Binds
    @IntoMap
    @ViewModelKey(ResultViewModel::class)
    abstract fun resultViewModel(viewModel: ResultViewModel): ViewModel
}