package tyde.com.contatcs.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tyde.com.contatcs.datasource.ContactsRepositoty
import tyde.com.contatcs.model.Data

class ContactsViewModel(): ViewModel() {
    private lateinit var contacts: MutableLiveData<List<Data?>>
    private lateinit var contact:MutableLiveData<Data?>
    private val contactsRepository= ContactsRepositoty()

    fun getMatches(): MutableLiveData<List<Data?>>{
        contacts =MutableLiveData<List<Data?>>()
        contactsRepository.getContacts(contacts)
        return contacts
    }

    fun setContact( data: Data){

        if(!::contact.isInitialized){
            contact= MutableLiveData()
        }
        this.contact.value=data
    }

    fun updateContact(data:Data): MutableLiveData<Data?>{
        contact =MutableLiveData<Data?>()
        contactsRepository.updateContacts(data)
        return contact
    }
}