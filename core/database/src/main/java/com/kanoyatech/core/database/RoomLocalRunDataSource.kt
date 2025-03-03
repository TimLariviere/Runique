package com.kanoyatech.core.database

import android.database.sqlite.SQLiteFullException
import com.kanoyatech.core.database.entities.dao.RunDao
import com.kanoyatech.core.database.mappers.toRun
import com.kanoyatech.core.database.mappers.toRunEntity
import com.kanoyatech.core.domain.run.LocalRunDataSource
import com.kanoyatech.core.domain.run.Run
import com.kanoyatech.core.domain.run.RunId
import com.kanoyatech.core.domain.util.DataError
import com.kanoyatech.core.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalRunDataSource(
    private val runDao: RunDao
): LocalRunDataSource {
    override fun getRuns(): Flow<List<Run>> {
        return runDao.getRuns()
            .map { runEntities ->
                runEntities.map { it.toRun() }
            }
    }

    override suspend fun upsertRun(run: Run): Result<RunId, DataError.Local> {
        try {
            val entity = run.toRunEntity()
            runDao.upsertRun(entity)
            return Result.Success(entity.id)
        } catch (e: SQLiteFullException) {
            return Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun upsertRuns(runs: List<Run>): Result<List<RunId>, DataError.Local> {
        try {
            val entities = runs.map { it.toRunEntity() }
            runDao.upsertRuns(entities)
            return Result.Success(entities.map { it.id })
        } catch (e: SQLiteFullException) {
            return Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteRun(id: RunId) {
        runDao.deleteRun(id)
    }

    override suspend fun deleteAllRuns() {
        runDao.deleteAllRuns()
    }
}