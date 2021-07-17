package com.atriz.group.repository

import com.atriz.database_api.CryptoDatabase
import com.atriz.database_api.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GroupRepository @Inject constructor(
    private val cryptoDatabase: CryptoDatabase,
) {

    suspend fun getAccountsInGroup(groupId: Long): List<Account> {
        val accounts: List<Account>

        withContext(Dispatchers.IO) {
            accounts = cryptoDatabase.getAllInGroup(groupId)
        }

        return accounts
    }
}
