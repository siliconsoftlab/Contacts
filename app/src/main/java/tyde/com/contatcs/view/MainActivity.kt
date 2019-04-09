package tyde.com.contatcs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.navigation.findNavController
import tyde.com.contatcs.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.hide()
       /* val inflater=layoutInflater;
       val customView= inflater.inflate(R.layout.actionbar_custom_view,null)

        actionBar!!.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)

        actionBar!!.setCustomView(customView)*/
       // actionBar!!.setHomeButtonEnabled(true)*/


    }
}
