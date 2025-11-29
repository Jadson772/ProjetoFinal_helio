package com.example.ecotracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurements")
data class MeasurementEntity(@PrimaryKey val id: String, val location: String?, val parameter: String?, val value: Double?, val unit: String?, val timestamp: String?)
