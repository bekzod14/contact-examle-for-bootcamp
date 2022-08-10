package uz.gita.contactexample.presenter

import androidx.lifecycle.LiveData

interface InfoViewModel {

    val backLiveData : LiveData<Unit>

    fun back()
}