package com.atriz.home.repository

import com.atriz.database_api.DatabaseFactory
import com.atriz.database_api.model.Account
import com.atriz.database_api.model.Group
import com.atriz.database_api.model.AccountWithGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {

    suspend fun getGroups(): List<Group> {
        val groups: List<Group>

        withContext(Dispatchers.IO) {
            groups = databaseFactory.groups().getAll()
        }

        return groups
    }

    suspend fun getAccountsWithGroup(): List<AccountWithGroup> {
        val accounts: List<AccountWithGroup>

        withContext(Dispatchers.IO) {
            accounts = databaseFactory.accounts().getAllWithGroup()
        }

        return accounts
    }

    suspend fun createGroup(group: Group) {
        withContext(Dispatchers.IO) {
            databaseFactory.groups().insert(group)
        }
    }

    suspend fun getAccountsInGroup(idGroup: Long): List<Account> {
        val accounts: List<Account>

        withContext(Dispatchers.IO) {
            accounts = databaseFactory.accounts().getAllInGroup(idGroup)
        }

        return accounts
    }

    suspend fun createAccount(account: Account) {
        withContext(Dispatchers.IO) {
            databaseFactory.accounts().insert(account)
        }
    }
}
