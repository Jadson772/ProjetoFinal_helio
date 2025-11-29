package com.ecotracker.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ecotracker.data.local.MeasurementEntity
import kotlinx.coroutines.flow.Flow

@Dao interface MeasurementDao {
    @Query("SELECT * FROM measurements ORDER BY timestamp DESC") fun getAll(): Flow<List<MeasurementEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(items: List<MeasurementEntity>)
}
