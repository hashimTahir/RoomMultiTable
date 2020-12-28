/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities.dao

import androidx.room.*
import com.hashim.roommultitable.entities.Director
import com.hashim.roommultitable.entities.relations.SchoolAndDirector

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertSchool(school: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertDirector(director: Director)


    @Transaction /*Make sure there is not multi threading issues*/
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun hGetSchoolAndDirectorwithSchoolName(schoolName: String): List<SchoolAndDirector>

}