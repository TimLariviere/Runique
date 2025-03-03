package com.kanoyatech.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kanoyatech.core.database.entities.RunEntity
import com.kanoyatech.core.database.entities.dao.RunDao

@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase: RoomDatabase() {
    abstract val runDao: RunDao
}