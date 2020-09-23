package cl.alejandroperez.amiibo.model.api.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface AmiiboDao {

    @Query("select * from amiibo_table")
    fun getAllAmiibo(): LiveData<List<EntityAmiibo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAmiibo(amiiboList:List<EntityAmiibo>)

}