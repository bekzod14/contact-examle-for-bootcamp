package uz.gita.contactexample.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactexample.data.model.ContactData
import uz.gita.contactexample.presenter.AddContactViewModel
import uz.gita.contactexample.repository.Repository
import uz.gita.contactexample.utils.isPhoneNumber

class AddContactViewModelImpl : AddContactViewModel, ViewModel() {
    private var img: String?  = null
    private val repository = Repository

    override val backLiveData: MutableLiveData<Unit> = MutableLiveData()

    override val messageLiveData: MutableLiveData<String> = MutableLiveData()

    override val manImgLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override val woManImgLiveData: MutableLiveData<Boolean> = MutableLiveData()

    init {
        manImgLiveData.value = false
        woManImgLiveData.value = false
    }

    override fun saveContact(name: String, phone: String) {
        if (name.isEmpty()) {
            messageLiveData.value = "ismingni kirit"
        }else if (!phone.isPhoneNumber()) {
            messageLiveData.value = "telefon raqqamingni kirit"
        }else if (img == null) {
            messageLiveData.value = "rasmingni tanla"
        }else {
            repository.insert(ContactData(0, name, phone, img!!))
            messageLiveData.value = "contact saqlandi"
            back()
        }
    }

    override fun back() {
        backLiveData.value = Unit
    }

    override fun selectManImg() {
        if (img == "man") {
            img = null
            manImgLiveData.value = false
        }else{
            img = "man"
            manImgLiveData.value = true
            woManImgLiveData.value = false
        }
    }

    override fun selectWomanImg() {
        if (img == "woman") {
            img = null
            woManImgLiveData.value = false
        }else{
            img = "woman"
            manImgLiveData.value = false
            woManImgLiveData.value = true
        }
    }
}