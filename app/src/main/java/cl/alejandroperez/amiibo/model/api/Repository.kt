package cl.alejandroperez.amiibo.model.api

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.room.RoomDatabase
/*import cl.alejandroperez.amiibo.model.db.DataBaseAmiibo
import cl.alejandroperez.amiibo.model.db.EntityAmiibo*/
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/*

class Repository (context: Context) {

    var dataBaseAmiibo = DataBaseAmiibo.getDatabase(context)
    var listAmiibo = dataBaseAmiibo.getDaoAmiibo().getAllAmiibo()

    fun loadApiAmiibo() {

        val call = RetrofitClient.retrofitIntance().getAllAmiiboValues()
        call.enqueue(object : Callback<Amiibo> {
            override fun onResponse(call: Call<Amiibo>, response: Response<Amiibo>) {

                response.body()?.amiibo?.map {
                    Log.d("MAIN", " ${it.tail} - ${it.name} - ${it.image}  ")
                    listAmiibo// Agregamos cada post a la lista de post
                    Log.d("TAG", "${listAmiibo}")
                }
             //   viewAdapter.notifyDataSetChanged()

                */
/*  Log.d("TAG", response.code().toString())
                  Log.d("TAG2","${response.body().toString()}")
                  Log.d("TAG3","${response}")
                  Log.d("TAG4","${response.body()?.amiibo?.get(0)}" )*//*



            }

            override fun onFailure(call: Call<Amiibo>, t: Throwable) {
                Log.d("MAIN", "Error: " + t)

            }
        })


    }
}

*/
