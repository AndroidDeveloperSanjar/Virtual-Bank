package uz.androbeck.virtualbank.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    // for example
    @ColumnInfo(name = "name")
    val nem: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "token")
    val token: String
)
