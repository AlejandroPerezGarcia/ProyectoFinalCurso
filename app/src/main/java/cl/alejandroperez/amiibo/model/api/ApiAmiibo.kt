package cl.alejandroperez.amiibo.model.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiAmiibo {

   /*  @GET("/api/amiibo")
    fun getAllAmiibo () : Call<List<Amiibo>>*/

    // amiibo/
    @GET("amiibo/")
    fun getAllAmiiboValues():Call<Amiibo>

}
