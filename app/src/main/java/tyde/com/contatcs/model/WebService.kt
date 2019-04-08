package tyde.com.contatcs.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WebService {

    @GET("users")
    fun getMatches(): Call<WebServiceResponse>


}