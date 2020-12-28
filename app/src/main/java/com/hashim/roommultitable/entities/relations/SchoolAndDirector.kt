/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hashim.roommultitable.entities.Director
import com.hashim.roommultitable.entities.School

/*one to one relation*/
data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)