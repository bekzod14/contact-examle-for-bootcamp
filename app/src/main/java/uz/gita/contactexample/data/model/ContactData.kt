package uz.gita.contactexample.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactData (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val number:String,
    val image:Int
)