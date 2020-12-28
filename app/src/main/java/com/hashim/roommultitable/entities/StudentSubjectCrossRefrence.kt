/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities

import androidx.room.Entity

/*For n-m relations two classes are required studentsWithSubjects and SubjectsWithStudent*/
@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRefrence(
    val studentName: String,
    val subjectName: String,
    )
