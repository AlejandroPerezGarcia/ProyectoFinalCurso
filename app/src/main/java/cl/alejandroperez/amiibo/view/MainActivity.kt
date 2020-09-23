package cl.alejandroperez.amiibo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cl.alejandroperez.amiibo.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("activiti" , "hola")


    }


}

