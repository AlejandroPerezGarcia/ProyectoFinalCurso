package cl.alejandroperez.amiibo.model.api

import android.content.Context
import android.util.Log
import androidx.room.PrimaryKey
import cl.alejandroperez.amiibo.model.api.db.DataBaseAmiibo
import cl.alejandroperez.amiibo.model.api.db.EntityAmiibo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(context: Context) {

    var dataBaseAmiibo = DataBaseAmiibo.getDatabase(context)
    var listAmiibo = dataBaseAmiibo.getDaoAmiibo().getAllAmiibo()

    fun loadApiAmiibo() {

        val service = RetrofitClient.retrofitIntance()
        val call = service.getAllAmiiboValues()

        call.enqueue(object : Callback<Amiibo> {

            override fun onResponse(call: Call<Amiibo>, response: Response<Amiibo>) {
                Log.d("api", "${response.body()?.amiibo}")
                converter(response.body()?.amiibo)
            }

            override fun onFailure(call: Call<Amiibo>, t: Throwable) {
                Log.d("Adapter", "Error al cargar heroes")
            }
        })
    }

    fun saveDatabase(listAmiiboEntity: List<EntityAmiibo>) {
        Log.d("api+++", "entramos")
        CoroutineScope(Dispatchers.IO).launch {
            dataBaseAmiibo.getDaoAmiibo()
                .insertAmiibo(listAmiiboEntity as MutableList<EntityAmiibo>)
        }
    }

    var listAmiibo1 = ArrayList<EntityAmiibo>()


    private fun converter(amiibo: List<AmiiboX>?) {

        amiibo?.map {
            listAmiibo1.add(
                EntityAmiibo(
                    it.amiiboSeries,
                    it.character,
                    it.gameSeries,
                    it.image,
                    it.name,
                    it.tail,
                    it.type
                )
            )
        }
        Log.d("repository convertet", "Converter")
        saveDatabase(listAmiibo1)
    }

}



