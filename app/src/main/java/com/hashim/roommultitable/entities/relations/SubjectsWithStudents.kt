/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hashim.roommultitable.entities.Student
import com.hashim.roommultitable.entities.StudentSubjectCrossRefrence
import com.hashim.roommultitable.entities.Subject


data class SubjectsWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRefrence::class)
    )
    val subjects: List<Student>
)