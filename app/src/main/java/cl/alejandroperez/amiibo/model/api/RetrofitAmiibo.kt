package cl.alejandroperez.amiibo.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.amiiboapi.com/api/"

class RetrofitClient {
    companion object {
        fun retrofitIntance(): ApiAmiibo {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiAmiibo::class.java)
        }
    }
}