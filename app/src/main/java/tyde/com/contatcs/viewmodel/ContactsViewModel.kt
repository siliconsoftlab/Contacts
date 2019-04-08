package tyde.com.contatcs.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tyde.com.contatcs.datasource.ContactsRepositoty
import tyde.com.contatcs.model.Data

class ContactsViewModel(): ViewModel() {
    private lateinit var contacts: MutableLiveData<List<Data?>>
    private val contactsRepository= ContactsRepositoty()

    fun getMatches(): MutableLiveData<List<Data?>>{
        val filterCondition= HashMap<String,String>()
        contacts =MutableLiveData<List<Data?>>()
        contactsRepository.getContacts(filterCondition,contacts)
        return contacts
    }
}