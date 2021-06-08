package com.atriz.database_api.api

import com.atriz.database_api.model.Favorites
import com.atriz.database_api.model.Group

interface DatabaseApi {

    fun getGroups(): List<Group>

    fun getFavorites(): List<Favorites>
}
