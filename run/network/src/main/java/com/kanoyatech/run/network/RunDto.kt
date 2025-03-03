package com.kanoyatech.run.network

import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class RunDto(
    val id: String,
    val dateTime: String,
    val durationMillis: Long,
    val distanceMeters: Int,
    val lat: Double,
    val long: Double,
    val avgSpeedKmh: Double,
    val maxSpeedKmh: Double,
    val totalElevationMeters: Int,
    val mapPictureUrl: String?
)
