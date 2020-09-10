package cl.alejandroperez.amiibo.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.alejandroperez.amiibo.model.api.Amiibo


/*
@Dao

interface DaoAmiibo {

    @Query("select *from amiibo_Table")
    fun getAllAmiibo(): LiveData<List<Amiibo>>

   */
/* @Query("select tail,name,image from amiibo_table")
    fun getAllAmiiboMini() : LiveData<List<Amiibo>>*//*


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAmiibo(amiiboList: List<EntityAmiibo>)
}

*/
