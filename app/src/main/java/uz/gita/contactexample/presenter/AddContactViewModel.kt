package uz.gita.contactexample.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.gita.contactexample.data.model.ContactData

interface AddContactViewModel {

    val backLiveData : LiveData<Unit>

    val messageLiveData : LiveData<String>

    val manImgLiveData : LiveData<Boolean>

    val woManImgLiveData : LiveData<Boolean>

    fun saveContact(name : String, phone : String)

    fun back()

    fun selectManImg()

    fun selectWomanImg()


}