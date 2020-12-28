/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities.dao

import androidx.room.*
import com.hashim.roommultitable.entities.Director
import com.hashim.roommultitable.entities.Student
import com.hashim.roommultitable.entities.relations.SchoolAndDirector
import com.hashim.roommultitable.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertSchool(school: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertDirector(director: Director)


    /*Make sure there is not multi threading issues*/
    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun hGetSchoolAndDirectorwithSchoolName(schoolName: String): List<SchoolAndDirector>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun hGetSchoolwithStudents(schoolName: String): List<SchoolWithStudents>


}