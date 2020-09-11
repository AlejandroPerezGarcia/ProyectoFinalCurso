package cl.alejandroperez.amiibo.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "amiibo_table")
class EntityAmiibo (

    @PrimaryKey val tail : String,
    val amiiboSeries : String,
    val gameSeries : String,
    val character: String,
    val image : String,
    val name : String,
    val type : String

)
/*
amiiboSeries	"Super Smash Bros."
character	"Mario"
gameSeries	"Super Mario"
head	"00000000"
image	"https://raw.githubusercontent.com/N3evin/AmiiboAPI/master/images/icon_00000000-00000002.png"
name	"Mario"
tail	"00000002"
type	"Figure"*/