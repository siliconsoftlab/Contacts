package tyde.com.contatcs.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import tyde.com.contatcs.R
import tyde.com.contatcs.model.UserModel

class ContactsAdapter(val context: Context?, val users:List<UserModel>, val fragment: Fragment): RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view=  LayoutInflater.from(context).inflate(R.layout.recyclerview_item_row,parent,false)
        return ContactsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val user=users[position]
        holder.setData(user,position)
    }

    inner class ContactsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
init {
itemView.setOnClickListener {
    it.findNavController().navigate(R.id.action_contactsFragment_to_contactDetailFragment)
}
}
        fun setData(user: UserModel?, position: Int) {

            /*itemView.nameTv.text=match!!.name
            itemView.ageTv.text=match.sex
            itemView.eduTv.text=match.email
            Log.d("ContactsAdapter ",match.profileImage)
            Picasso.with(context)
                .load(match.profileImage)
                .placeholder(R.drawable.ic_launcher_background)
                .resize(200,200)
                .into(itemView.circleImageView);
            this.curmatchModel=match
            this.position=position*/
        }
    }
}