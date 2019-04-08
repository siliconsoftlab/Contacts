package tyde.com.contatcs.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactsRepositoty {
    private val service: WebService = ServiceBuilder.buildService(WebService::class.java)
    fun getContacts(filterMatches:HashMap<String,String>,users: MutableLiveData<List<Data?>>){
        Log.d("ContactsRepositoty", "" + "INside getcontactsx ContactsRepositoty")

        val service: WebService = ServiceBuilder.buildService(WebService::class.java)

        val loginRequestCall: Call<WebServiceResponse> = service.getMatches()


        loginRequestCall.enqueue(object : Callback<WebServiceResponse>{
            override fun onFailure(call: Call<WebServiceResponse>, t: Throwable) {
                Log.d("ContactsRepositoty", "" + " !!!!!! Could not get data "+t.printStackTrace())
            }

            override fun onResponse(call: Call<WebServiceResponse>, response: Response<WebServiceResponse>) {
                if(response.isSuccessful){
                    val res:WebServiceResponse = response.body()!!
                    Log.d("ContactsRepositoty", "" + " $$$$$$$$$$$$$$ success "+response.body())
                    users.value= response.body()?.data

                    Log.d("ContactsRepositoty",""+res.toString())

                }else {
                    Log.d("ContactsRepositoty","not success")
                    val result = when (response.code()) {
                        404 ->  "Users not found for your query "+ response.code()
                        500 -> "Internal Server Error "+ response.code()
                        else -> "Internal Server Error "+ response.code()
                    }

                }
            }
        })
    }

}