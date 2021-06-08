package com.atriz.database_api.model

import androidx.room.Embedded
import androidx.room.Relation

data class AccountWithGroup(
    @Embedded
    val account: Account,

    @Relation(
            parentColumn = "group_id",
            entityColumn = "group_id"
    )
    val group: Group
)
