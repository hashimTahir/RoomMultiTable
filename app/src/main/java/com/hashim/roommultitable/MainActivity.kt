/*
 * Copyright (c) 2020/  12/ 26.  Created by Hashim Tahir
 */

package com.hashim.roommultitable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.hashim.roommultitable.entities.Director
import com.hashim.roommultitable.entities.School
import com.hashim.roommultitable.entities.Student
import com.hashim.roommultitable.entities.Subject
import com.hashim.roommultitable.entities.StudentSubjectCrossRefrence
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var directors: List<Director>
    lateinit var schools: List<School>
    lateinit var subjects: List<Subject>
    lateinit var students: List<Student>
    lateinit var studentSubjectRelations: List<StudentSubjectCrossRefrence>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hDao = SchoolDb.hGetInstance(this).hSchoolDao

        hCreateTempData()

        lifecycleScope.launch {
            directors.forEach {
                hDao.hInsertDirector(it)

            }
            schools.forEach {
                hDao.hInsertSchool(it)

            }
            subjects.forEach {
                hDao.hInsertSubject(it)

            }
            students.forEach {
                hDao.hInsertStudent(it)

            }

            studentSubjectRelations.forEach {
                hDao.hInsertStudentSubjectCrossRef(it)

            }

        }
    }

    private fun hCreateTempData() {
        directors = listOf(
            Director("Mike Litoris", "Jake Wharton School"),
            Director("Jack Goff", "Kotlin School"),
            Director("Chris P. Chicken", "JetBrains School")
        )
        schools = listOf(
            School("Jake Wharton School"),
            School("Kotlin School"),
            School("JetBrains School")
        )
        subjects = listOf(
            Subject("Dating for programmers"),
            Subject("Avoiding depression"),
            Subject("Bug Fix Meditation"),
            Subject("Logcat for Newbies"),
            Subject("How to use Google")
        )
        students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Mark Suckerberg", 5, "Jake Wharton School"),
            Student("Gill Bates", 8, "Kotlin School"),
            Student("Donny Jepp", 1, "Kotlin School"),
            Student("Hom Tanks", 2, "JetBrains School")
        )
        studentSubjectRelations = listOf(
            StudentSubjectCrossRefrence("Beff Jezos", "Dating for programmers"),
            StudentSubjectCrossRefrence("Beff Jezos", "Avoiding depression"),
            StudentSubjectCrossRefrence("Beff Jezos", "Bug Fix Meditation"),
            StudentSubjectCrossRefrence("Beff Jezos", "Logcat for Newbies"),
            StudentSubjectCrossRefrence("Mark Suckerberg", "Dating for programmers"),
            StudentSubjectCrossRefrence("Gill Bates", "How to use Google"),
            StudentSubjectCrossRefrence("Donny Jepp", "Logcat for Newbies"),
            StudentSubjectCrossRefrence("Hom Tanks", "Avoiding depression"),
            StudentSubjectCrossRefrence("Hom Tanks", "Dating for programmers")
        )
    }
}