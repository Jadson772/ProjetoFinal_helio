package com.example.ecotracker.data.repository

import com.ecotracker.app.data.local.MeasurementDao
import com.example.ecotracker.data.local.MeasurementEntity
import com.example.ecotracker.data.network.OpenAQService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class MeasurementRepository @Inject constructor(private val service: OpenAQService, private val dao: MeasurementDao) {
    suspend fun refresh(city: String? = null) { val res = service.measurements(city = city, limit = 50); val entities = res.results.mapIndexed { idx, it -> MeasurementEntity(id = (it.location ?: "loc") + "_" + idx, location = it.location, parameter = it.parameter, value = it.value, unit = it.unit, timestamp = it.date?.get("utc")?.toString()) }; dao.insertAll(entities) }
    fun observeMeasurements(): Flow<List<MeasurementEntity>> = dao.getAll().map { it }
}