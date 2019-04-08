package tyde.com.contatcs.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import tyde.com.contatcs.R
import tyde.com.contatcs.model.Data
import tyde.com.contatcs.viewmodel.ContactsViewModel

class ContactsAdapter(val context: Context?, val contacts: List<Data?>, val fragment: Fragment) :
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_row, parent, false)
        return ContactsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val user = contacts[position]
        holder.setData(user, position)
    }

    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var  selectedContact: Data?=null
        var position: Int?=0
        init {
            itemView.setOnClickListener {
                val contact= ViewModelProviders.of(fragment).get(ContactsViewModel::class.java)
                contact.setContact(selectedContact!!)
                val bundle = Bundle()
                bundle.putParcelable("contact",selectedContact)
                it.findNavController().navigate(R.id.action_contactsFragment_to_contactDetailFragment,bundle)
            }
        }

        fun setData(contact: Data?, position: Int) {
            itemView.tv_user_name.text=contact?.first_name

            Picasso.with(context)
                .load(contact?.avatar)
                .placeholder(R.drawable.ic_launcher_background)
                .resize(200,200)
                .into(itemView.imgVw_user_pic)
            this.selectedContact=contact
            this.position=position
        }
    }
}