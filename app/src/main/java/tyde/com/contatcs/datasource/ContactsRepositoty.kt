package tyde.com.contatcs.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tyde.com.contatcs.model.Data
import tyde.com.contatcs.model.WebServiceResponse

class ContactsRepositoty {
    private val service: WebService =
        ServiceBuilder.buildService(WebService::class.java)
    fun getContacts(users: MutableLiveData<List<Data?>>){

        val getContacts: Call<WebServiceResponse> = service.getContacts()


        getContacts.enqueue(object : Callback<WebServiceResponse>{
            override fun onFailure(call: Call<WebServiceResponse>, t: Throwable) {
                Log.e("ContactsRepository", "" + " App could not get data: More Info "+t.printStackTrace())
            }

            override fun onResponse(call: Call<WebServiceResponse>, response: Response<WebServiceResponse>) {
                if(response.isSuccessful){
                    val res: WebServiceResponse = response.body()!!
                    Log.d("ContactsRepository", "" + " $$$$$$$$$$$$$$ success "+response.body())
                    Log.d("ContactsRepository",""+res.toString())
                    users.value= response.body()?.data
                }else {
                    Log.d("ContactsRepository","not success")

                }
            }
        })
    }
    fun updateContacts(data: Data){

        val updateReq: Call<WebServiceResponse> = service.updateContact(data.id.toString(),data)

        updateReq.enqueue(object : Callback<WebServiceResponse>{
            override fun onFailure(call: Call<WebServiceResponse>, t: Throwable) {
                Log.e("ContactsRepository", "" + " App could not get data: More Info "+t.printStackTrace())
            }

            override fun onResponse(call: Call<WebServiceResponse>, response: Response<WebServiceResponse>) {
                if(response.isSuccessful){
                    val res: WebServiceResponse = response.body()!!
                    Log.d("ContactsRepository", "" + " $$$$$$$$$$$$$$ success "+response.body())
                    Log.d("ContactsRepository",""+res.toString())
                    //users.value= response.body()?.data
                }else {
                    Log.d("ContactsRepository","not success")

                }
            }
        })
    }
}