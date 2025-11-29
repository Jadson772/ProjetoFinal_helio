package com.ecotracker.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecotracker.data.local.MesurementEntity

@Database(entities = [MesurementEntity::class], version = 1) abstract class AppDatabase : RoomDatabase() { abstract fun measurementDao(): MeasurementDao }
