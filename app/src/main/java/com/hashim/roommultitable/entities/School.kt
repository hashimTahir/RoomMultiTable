/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
) {
}