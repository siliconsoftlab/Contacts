package tyde.com.contatcs.datasource

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import tyde.com.contatcs.model.Data
import tyde.com.contatcs.model.WebServiceResponse

interface WebService {

    @GET("users?per_page=10")
    fun getContacts(): Call<WebServiceResponse>

    @PUT("users/{id}/")
    fun updateContact(@Path("id") id:String,@Body data: Data): Call<WebServiceResponse>

}