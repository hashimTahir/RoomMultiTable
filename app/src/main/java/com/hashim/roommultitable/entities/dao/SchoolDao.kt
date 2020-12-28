/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities.dao

import androidx.room.*
import com.hashim.roommultitable.entities.*
import com.hashim.roommultitable.entities.relations.*

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertSchool(school: School)

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


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertSubject(subject: Subject)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun hInsertStudentSubjectCrossRef(crossRefrence: StudentSubjectCrossRefrence)


    @Transaction
    @Query("SELECT * FROM Subject WHERE subjectName = :subjectName")
    suspend fun hGetStudentsofSubject(subjectName: String): List<SubjectsWithStudents>


    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun hGetSubjectsOfStudents(studentName: String): List<StudentWithSubjects>

}