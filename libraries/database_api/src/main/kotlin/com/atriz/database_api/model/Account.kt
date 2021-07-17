package com.atriz.database_api.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Suppress("DataClassShouldBeImmutable")
@Entity(tableName = "accounts_table")
data class Account(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "account_id")
    var accountId: Long,

    @ColumnInfo(name = "group_id")
    val groupId: Long,

    @ColumnInfo(name = "auth_name")
    val accountName: String,

    @ColumnInfo(name = "auth_password")
    val accountPassword: String,

    @ColumnInfo(name = "last_update_in_millis")
    val lastUpdateInMillis: Long,

    @ColumnInfo(name = "is_favorites")
    val isFavorites: Boolean
) : Parcelable {

    fun convert(action: (message: String) -> String): Account {
        return Account(
            accountId = accountId,
            groupId = groupId,
            accountName = action.invoke(accountName),
            accountPassword = action.invoke(accountPassword),
            lastUpdateInMillis = lastUpdateInMillis,
            isFavorites = isFavorites
        )
    }
}
