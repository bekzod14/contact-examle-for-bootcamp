package uz.gita.contactexample.presenter.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.contactexample.data.model.ContactData
import uz.gita.contactexample.presenter.MainViewModel
import uz.gita.contactexample.repository.Repository

class MainViewModelImpl : MainViewModel, ViewModel() {

    private val repository = Repository

    override val contactListLiveData = MutableLiveData<List<ContactData>>()
    override val openAddContactLiveData = MutableLiveData<Unit>()
    override val openInfoLiveData = MutableLiveData<Unit>()
    override val openEditLiveData = MutableLiveData<ContactData>()

    override fun openAddContactScreen() {
        
    }

    override fun openInfoScreen() {
        TODO("Not yet implemented")
    }

    override fun openEditContactScreen(contactData: ContactData) {
        TODO("Not yet implemented")
    }

    override fun deleteContact(contactData: ContactData) {
        TODO("Not yet implemented")
    }
}