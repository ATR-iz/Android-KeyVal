package com.atriz.database_api.dao

import androidx.room.*
import com.atriz.database_api.model.Group

@Dao
interface GroupsDao {
    @Query("SELECT * FROM groups_table")
    fun getAll(): List<Group>

    @Query("SELECT * FROM groups_table WHERE group_id IN (:position)")
    fun get(position: Long?): Group

    @Update
    fun update(item: Group)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Group): Long

    @Query("DELETE FROM groups_table WHERE group_id IN (:position)")
    fun delete(position: Long)

    @Delete
    fun delete(item: Group)
}
