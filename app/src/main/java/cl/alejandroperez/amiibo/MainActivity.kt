package cl.alejandroperez.amiibo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cl.alejandroperez.amiibo.model.api.Amiibo
import cl.alejandroperez.amiibo.model.api.AmiiboX
import cl.alejandroperez.amiibo.model.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var amiiboList = mutableListOf<AmiiboX>()
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = AmiiboAdapter(amiiboList)
        amiiboRecyclerView.adapter = viewAdapter

        loadApiData()

    }

    private fun loadApiData() {
        val service = RetrofitClient.retrofitIntance()
        val call = service.getAllAmiiboValues()

        call.enqueue(object : Callback<Amiibo> {

            override fun onResponse(call: Call<Amiibo>, response: Response<Amiibo>) {

                response.body()?.amiibo?.map {

                    amiiboList.add(it)
                }

                viewAdapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<Amiibo>, t: Throwable) {
                Log.d("MAIN", "Error: " + t)
                Toast.makeText(
                    applicationContext,
                    "Error: no pudimos recuperar los posts desde el api",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}

