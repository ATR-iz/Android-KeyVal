package com.atriz.database_api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.atriz.database_api.dao.AccountsDao
import com.atriz.database_api.dao.GroupsDao
import com.atriz.database_api.model.Account
import com.atriz.database_api.model.Group

@Database(entities = [Group::class, Account::class], version = 1)
internal abstract class DatabaseFactory : RoomDatabase() {

    companion object {
        fun build(context: Context): DatabaseFactory {
            return Room.databaseBuilder(context, DatabaseFactory::class.java, "db").build()
        }
    }

    abstract fun groups(): GroupsDao
    abstract fun accounts(): AccountsDao
}
