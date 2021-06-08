package com.atriz.database_api

import com.atriz.database_api.api.DatabaseApi
import com.atriz.database_api.api.DatabaseApiImpl

class DatabaseFactory {

    companion object {
        fun getInstance(): DatabaseFactory {
            return DatabaseFactory()
        }
    }

    val api: DatabaseApi = DatabaseApiImpl()
}
