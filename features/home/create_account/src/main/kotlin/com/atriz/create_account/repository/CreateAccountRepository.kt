package com.atriz.create_account.repository

import com.atriz.database_api.DatabaseFactory
import com.atriz.database_api.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreateAccountRepository @Inject constructor(
    private val databaseFactory: DatabaseFactory,
) {

    suspend fun createAccount(account: Account) {
        withContext(Dispatchers.IO) {
            databaseFactory.accounts().insert(account)
        }
    }
}
