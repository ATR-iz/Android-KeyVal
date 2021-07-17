package com.atriz.create_group.repository

import com.atriz.database_api.CryptoDatabase
import com.atriz.database_api.model.Group
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreateGroupRepository @Inject constructor(
    private val cryptoDatabase: CryptoDatabase,
) {

    suspend fun createGroup(group: Group) {
        withContext(Dispatchers.IO) {
            cryptoDatabase.insert(group)
        }
    }
}
