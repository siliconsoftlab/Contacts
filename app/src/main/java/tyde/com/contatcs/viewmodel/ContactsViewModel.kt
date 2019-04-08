package tyde.com.contatcs.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tyde.com.contatcs.model.ContactsRepositoty
import tyde.com.contatcs.model.Data

class ContactsViewModel(): ViewModel() {
    private lateinit var contacts: MutableLiveData<List<Data?>>
    private lateinit var contact:MutableLiveData<Data>
    private val contactsRepositoty=ContactsRepositoty()

    fun getMatches(): MutableLiveData<List<Data?>>{
        Log.d("#############Step6 "," Step6")
        val filterMatches= HashMap<String,String>()
        contacts =MutableLiveData<List<Data?>>()
        contactsRepositoty.getContacts(filterMatches,contacts)
        return contacts
    }
}