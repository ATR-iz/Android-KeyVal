package com.atriz.database_api

import android.content.Context
import com.atriz.crypto_api.CryptoApi
import com.atriz.database_api.model.Account
import com.atriz.database_api.model.AccountWithGroup
import com.atriz.database_api.model.Group

class CryptoDatabase(context: Context, private val cryptoApi: CryptoApi) {

    private var databaseFactory: DatabaseFactory = DatabaseFactory.build(context)

    fun getAllGroups(): List<Group> {
        return databaseFactory.groups().getAll().map { group ->
            group.convert { cryptoApi.decrypt(it) }
        }
    }

    fun getAllAccountsWithGroup(): List<AccountWithGroup> {
        return databaseFactory.accounts().getAllWithGroup().map { accountWithGroup ->
            AccountWithGroup(
                accountWithGroup.account.convert { cryptoApi.decrypt(it) },
                accountWithGroup.group.convert { cryptoApi.decrypt(it) }
            )
        }
    }

    fun insert(account: Account) {
        val encryptedAccount = account.convert { cryptoApi.encrypt(it) }
        databaseFactory.accounts().insert(encryptedAccount)
    }

    fun insert(group: Group) {
        val encryptedGroup = group.convert { cryptoApi.encrypt(it) }
        databaseFactory.groups().insert(encryptedGroup)
    }

    fun getAllInGroup(groupId: Long): List<Account> {
        return databaseFactory.accounts().getAllInGroup(groupId).map { account ->
            account.convert { cryptoApi.decrypt(it) }
        }
    }
}