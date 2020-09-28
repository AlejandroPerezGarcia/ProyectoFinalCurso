package cl.alejandroperez.amiibo.model.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiAmiibo {

    @GET("amiibo/")
    fun getAllAmiiboValues(): Call<Amiibo>

}
