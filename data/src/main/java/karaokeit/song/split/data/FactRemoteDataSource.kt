package karaokeit.song.split.data

import karaokeit.song.split.domain.base.ApiResult
import karaokeit.song.split.domain.model.FactsDomainModel
import kotlinx.coroutines.flow.Flow

interface FactRemoteDataSource {
    suspend fun getCatFacts(): Flow<ApiResult<FactsDomainModel>>
}