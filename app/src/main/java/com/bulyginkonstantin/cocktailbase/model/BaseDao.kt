package com.bulyginkonstantin.cocktailbase.model

import androidx.room.*

@Dao
interface BaseDao<in T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T): Long

    @Delete
    fun delete(type : T)

}