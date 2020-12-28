/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hashim.roommultitable.entities.School
import com.hashim.roommultitable.entities.Student


/*For one to many relations*/
data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
