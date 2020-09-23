package cl.alejandroperez.amiibo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.alejandroperez.amiibo.model.api.Repository
import cl.alejandroperez.amiibo.model.api.db.EntityAmiibo

class AmiiboViewModel (application: Application) : AndroidViewModel(application){

    private var repository: Repository = Repository(application)
    var listAmiibo : LiveData<List<EntityAmiibo>> = repository.listAmiibo


    init {
        Log.d("repository2" , "${Repository(application)}")
        repository = Repository(application)
        Log.d("repository3", "${repository.loadApiAmiibo()}")
        repository.loadApiAmiibo()
    }
}