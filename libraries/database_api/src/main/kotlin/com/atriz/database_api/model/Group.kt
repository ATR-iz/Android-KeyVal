package com.atriz.database_api.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Suppress("DataClassShouldBeImmutable")
@Entity(tableName = "groups_table")
data class Group(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "group_id")
    var groupId: Long,

    @ColumnInfo(name = "group_name")
    val groupName: String,

    @ColumnInfo(name = "group_icon_path")
    val iconPath: String
) : Parcelable {

    fun convert(action: (message: String) -> String): Group {
        return Group(
            groupId = groupId,
            groupName = action.invoke(groupName),
            iconPath = action.invoke(iconPath)
        )
    }
}
