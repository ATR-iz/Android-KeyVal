package com.atriz.create_account.repository

import com.atriz.database_api.CryptoDatabase
import com.atriz.database_api.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CreateAccountRepository @Inject constructor(
    private val cryptoDatabase: CryptoDatabase,
) {

    suspend fun createAccount(account: Account) {
        withContext(Dispatchers.IO) {
            cryptoDatabase.insert(account)
        }
    }
}
