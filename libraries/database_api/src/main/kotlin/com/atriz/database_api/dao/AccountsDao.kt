package com.atriz.database_api.dao

import androidx.room.*
import com.atriz.database_api.model.Account
import com.atriz.database_api.model.AccountWithGroup

@Dao
interface AccountsDao {

    @Transaction
    @Query("SELECT * FROM accounts_table")
    fun getAllWithGroup(): List<AccountWithGroup>

    @Query("SELECT * FROM accounts_table")
    fun getAll(): List<Account>

    @Query("SELECT * FROM accounts_table WHERE account_id IN (:position)")
    fun get(position: Long?): Account

    @Update
    fun update(item: Account)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Account): Long

    @Query("DELETE FROM accounts_table WHERE account_id IN (:position)")
    fun delete(position: Long)

    @Delete
    fun delete(item: Account)
}
