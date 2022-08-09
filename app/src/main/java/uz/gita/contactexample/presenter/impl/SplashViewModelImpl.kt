package uz.gita.contactexample.presenter.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.contactexample.presenter.SplashViewModel

class SplashViewModelImpl : SplashViewModel, ViewModel() {

    override val openMainScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            delay(2000)
            openMainScreenLiveData.value = Unit
        }
    }
}