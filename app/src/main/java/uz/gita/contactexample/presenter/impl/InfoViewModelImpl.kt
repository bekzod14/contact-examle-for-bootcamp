package uz.gita.contactexample.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactexample.presenter.InfoViewModel

class InfoViewModelImpl : InfoViewModel,ViewModel() {
    override val backLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun back() {
        backLiveData.value = Unit
    }


}