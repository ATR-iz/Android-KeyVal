package com.atriz.database_api.api

import com.atriz.database_api.model.Favorites
import com.atriz.database_api.model.Group

internal class DatabaseApiImpl : DatabaseApi {

    override fun getGroups(): List<Group> {
        // Временная заглушка
        return listOf(
                Group("Local", ""),
                Group("Email", ""),
                Group("Google", "")
        )
    }

    override fun getFavorites(): List<Favorites> {
        // Временная заглушка
        return listOf(
                Favorites("Local", "admin", ""),
                Favorites("Google", "test-account@gmail.com", "")
        )
    }
}
