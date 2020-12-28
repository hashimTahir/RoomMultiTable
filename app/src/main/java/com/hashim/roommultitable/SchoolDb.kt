/*
 * Copyright (c) 2020/  12/ 28.  Created by Hashim Tahir
 */

package com.hashim.roommultitable

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hashim.roommultitable.entities.*
import com.hashim.roommultitable.entities.dao.SchoolDao
import com.hashim.roommultitable.entities.relations.SubjectsWithStudents

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        StudentSubjectCrossRefrence::class,
        Subject::class
    ],
    version = 1
)
abstract class SchoolDb : RoomDatabase() {
    abstract val hSchoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDb? = null

        fun hGetInstance(context: Context): SchoolDb {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDb::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}