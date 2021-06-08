package com.atriz.group.repository

import com.atriz.database_api.DatabaseFactory
import com.atriz.database_api.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GroupRepository @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {

    suspend fun getAccountsInGroup(groupId: Long): List<Account> {
        val accounts: List<Account>

        withContext(Dispatchers.IO) {
            accounts = databaseFactory.accounts().getAllInGroup(groupId)
        }

        return accounts
    }
}
