package cl.alejandroperez.amiibo.model.api.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface AmiiboDao {

    @Query("select * from amiibo_table")
    fun getAllAmiibo(): LiveData<List<EntityAmiibo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAmiibo(amiiboList:List<EntityAmiibo>)

    @Update
    suspend fun updateAmiibo(amiiboList: EntityAmiibo)

}