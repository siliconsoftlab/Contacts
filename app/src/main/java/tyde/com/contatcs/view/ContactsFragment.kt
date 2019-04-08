package tyde.com.contatcs.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_contacts.*

import tyde.com.contatcs.R
import tyde.com.contatcs.model.UserModel

class ContactsFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    var users= listOf(UserModel("Saran","pic1"),UserModel("Pradeesh","pic2"))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager= LinearLayoutManager(activity)
        recyclerView.layoutManager=linearLayoutManager

        val adapter= ContactsAdapter(context,users,this)
        recyclerView.adapter=adapter
    }
}
