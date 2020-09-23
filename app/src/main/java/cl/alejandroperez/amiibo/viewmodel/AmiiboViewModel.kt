package cl.alejandroperez.amiibo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cl.alejandroperez.amiibo.model.api.Repository
import cl.alejandroperez.amiibo.model.api.db.EntityAmiibo

class AmiiboViewModel (application: Application) : AndroidViewModel(application){

    private var repository: Repository = Repository(application)
    var listAmiibo : LiveData<List<EntityAmiibo>> = repository.listAmiibo

    init {
        repository = Repository(application)
        repository.loadApiAmiibo()
      }
    val datoSelecionado = MutableLiveData<EntityAmiibo>()

    fun selecionado(amiibo: EntityAmiibo){
        datoSelecionado.value = amiibo
    }

}