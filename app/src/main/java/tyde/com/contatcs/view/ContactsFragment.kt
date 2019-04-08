package tyde.com.contatcs.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_contacts.*

import tyde.com.contatcs.R
import tyde.com.contatcs.model.Data
import tyde.com.contatcs.viewmodel.ContactsViewModel

class ContactsFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager= LinearLayoutManager(activity)
        recyclerView.layoutManager=linearLayoutManager
        val contactsViewModel= ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        contactsViewModel.getMatches().observe(this, Observer<List<Data?>> { contacts->
            // showMsg("size of the match is ${users?.size}")
            Log.d("Inside query cinsition "," Inside query matches cond")
            Log.d(this::class.java.simpleName,"size of the match is ${contacts?.size}")

            val adapter= ContactsAdapter(context,contacts,this)
            recyclerView.adapter=adapter
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))

        })



    }
}
