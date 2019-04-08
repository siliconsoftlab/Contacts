package tyde.com.contatcs.datasource

import retrofit2.Call
import retrofit2.http.GET
import tyde.com.contatcs.model.WebServiceResponse

interface WebService {

    @GET("users?per_page=10")
    fun getMatches(): Call<WebServiceResponse>


}