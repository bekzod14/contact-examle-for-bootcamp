package uz.gita.contactexample.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.gita.contactexample.data.model.ContactData

@Dao
interface ContactDao {

    @Insert
    fun insert(contactData: ContactData)

    @Delete
    fun delete(contactData: ContactData)

    @Update
    fun update(contactData: ContactData)

    @Query("SELECT * FROM ContactData")
    fun getAllContacts(): LiveData<List<ContactData>>

}