package cl.alejandroperez.amiibo.model.api.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "amiibo_table")
class EntityAmiibo(

    val amiiboSeries: String,
    val character: String,
    val gameSeries: String,
    val image: String,
    val name: String,
    @PrimaryKey val tail: String,
    val type: String,
    var favorite : Boolean


)