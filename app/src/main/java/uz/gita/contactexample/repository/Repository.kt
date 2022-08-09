package uz.gita.contactexample.repository

import androidx.lifecycle.LiveData
import uz.gita.contactexample.data.model.ContactData
import uz.gita.contactexample.data.room.AppDatabase

object Repository {

    private val contactDao = AppDatabase.getDatabse().getContactDao()

    fun insert(contactData: ContactData) {
        contactDao.insert(contactData)
    }

    fun update(contactData: ContactData){
        contactDao.update(contactData)
    }

    fun delete(contactData: ContactData){
        contactDao.delete(contactData)
    }

    fun getAllContacts(): LiveData<List<ContactData>>{
        return contactDao.getAllContacts()
    }

}