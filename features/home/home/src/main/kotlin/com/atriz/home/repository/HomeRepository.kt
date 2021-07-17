package com.atriz.home.repository

import com.atriz.database_api.CryptoDatabase
import com.atriz.database_api.model.Group
import com.atriz.database_api.model.AccountWithGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val cryptoDatabase: CryptoDatabase,
) {

    suspend fun getGroups(): List<Group> {
        val groups: List<Group>

        withContext(Dispatchers.IO) {
            groups = cryptoDatabase.getAllGroups()
        }

        return groups
    }

    suspend fun getAccountsWithGroup(): List<AccountWithGroup> {
        val accounts: List<AccountWithGroup>

        withContext(Dispatchers.IO) {
            accounts = cryptoDatabase.getAllAccountsWithGroup()
        }

        return accounts
    }
}
