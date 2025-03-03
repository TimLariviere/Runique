package com.kanoyatech.core.database.mappers

import com.kanoyatech.core.database.entities.RunEntity
import com.kanoyatech.core.domain.run.Run
import com.kanoyatech.core.domain.location.Location
import org.bson.types.ObjectId
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunEntity.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc).atZone(ZoneId.of("UTC")),
        distanceMeters = distanceMeters,
        location = Location(
            lat = latitude,
            long = longitude
        ),
        maxSpeedKmh = maxSpeedKmh,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl
    )
}

fun Run.toRunEntity(): RunEntity {
    return RunEntity(
        id = id ?: ObjectId().toHexString(),
        durationMillis = duration.inWholeMilliseconds,
        maxSpeedKmh = maxSpeedKmh,
        dateTimeUtc = dateTimeUtc.toInstant().toString(),
        latitude = location.lat,
        longitude = location.long,
        totalElevationMeters = totalElevationMeters,
        distanceMeters = distanceMeters,
        avgSpeedKmh = avgSpeedKmh,
        mapPictureUrl = mapPictureUrl
    )
}