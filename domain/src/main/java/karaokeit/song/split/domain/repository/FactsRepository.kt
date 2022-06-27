package karaokeit.song.split.domain.repository

import karaokeit.song.split.domain.base.ApiResult
import karaokeit.song.split.domain.model.FactsDomainModel
import kotlinx.coroutines.flow.Flow

interface FactsRepository {
    suspend fun getCatFacts(): Flow<ApiResult<FactsDomainModel>>
}