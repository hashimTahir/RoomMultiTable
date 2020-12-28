/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName: String,
    val semester: Int,
    val schoolName: String

)
