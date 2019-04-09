package tyde.com.contatcs.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_contact_detail.*
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

import tyde.com.contatcs.R
import tyde.com.contatcs.model.Data


class ContactDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val data=arguments?.getParcelable<Data>("contact")
        tv_contact_name.text=data?.first_name
        Picasso.with(context)
            .load(data?.avatar)
            .placeholder(R.drawable.ic_launcher_background)
            .resize(400,400)
            .into(imgVw_profile_pic)
        tv_contact_id.text=data?.id.toString()
        val bundle = Bundle()
        bundle.putParcelable("contact",data)
        tv_edit.setOnClickListener { it.findNavController().navigate(R.id.action_contactDetailFragment_to_editContactFragment,bundle) }
        tv_contact.setOnClickListener { it.findNavController().popBackStack() }
    }





}



