package uz.gita.contactexample.presenter

import androidx.lifecycle.LiveData
import uz.gita.contactexample.data.model.ContactData

interface MainViewModel {
    val contactListLiveData: LiveData<List<ContactData>>
    val openAddContactLiveData: LiveData<Unit>
    val openInfoLiveData: LiveData<Unit>
    val openEditLiveData: LiveData<ContactData>

    fun openAddContactScreen()
    fun openInfoScreen()
    fun openEditContactScreen(contactData: ContactData)
    fun deleteContact(contactData: ContactData)
}