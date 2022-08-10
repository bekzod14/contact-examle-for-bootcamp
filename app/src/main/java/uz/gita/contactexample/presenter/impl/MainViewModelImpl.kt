package uz.gita.contactexample.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactexample.data.model.ContactData
import uz.gita.contactexample.presenter.MainViewModel
import uz.gita.contactexample.repository.Repository

class MainViewModelImpl : MainViewModel, ViewModel() {

    private val repository = Repository

    override val contactListLiveData = MediatorLiveData<List<ContactData>>()
    override val openAddContactLiveData = MutableLiveData<Unit>()
    override val openInfoLiveData = MediatorLiveData<Unit>()
    override val openEditLiveData = MutableLiveData<ContactData>()

    init {
        contactListLiveData.addSource(repository.getAllContacts()) {
            contactListLiveData.value = it
        }
    }

    override fun openAddContactScreen() {
        openAddContactLiveData.value = Unit
    }

    override fun openInfoScreen() {
        openInfoLiveData.value = Unit
    }

    override fun openEditContactScreen(contactData: ContactData) {
        openEditLiveData.value = contactData
    }

    override fun deleteContact(contactData: ContactData) {
        repository.delete(contactData)
    }
}