package tyde.com.contatcs.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.fragment_edit_contact.*

import tyde.com.contatcs.R
import tyde.com.contatcs.model.Data
import tyde.com.contatcs.viewmodel.ContactsViewModel


class EditContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getParcelable<Data>("contact")

        tv_first_name.setText(data?.first_name)
        tv_last_name.setText(data?.last_name)
        tv_contact_id.text=data?.id.toString()
        tv_done.setOnClickListener {

             val contactsViewModel= ViewModelProviders.of(this).get(ContactsViewModel::class.java)
            contactsViewModel.updateContact(data!!).observe(this, Observer<Data?> { contact->

                Toast.makeText(context,"  ********** ",Toast.LENGTH_LONG).show()
            })
        }
        tv_cancel.setOnClickListener {
            it.findNavController().popBackStack()
        }

    }
}
