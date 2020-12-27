/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.hashim.roommultitable.entities.Director

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertSchool(school: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertDirector(director: Director)


    suspend fun hGetSchoolAndDirectorwithSchool
}