package cl.alejandroperez.amiibo.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import cl.alejandroperez.amiibo.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("activiti" , "hola")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, AmiiboListFragment.newInstance("", ""), "vista")
                .commit()
        }else {
            supportFragmentManager.findFragmentByTag("vista")
        }
    }

}

