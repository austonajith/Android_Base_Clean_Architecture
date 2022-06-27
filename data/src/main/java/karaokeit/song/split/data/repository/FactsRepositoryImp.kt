package karaokeit.song.split.data.repository

import karaokeit.song.split.data.api.FactsApi
import karaokeit.song.split.data.mapper.FactsRepositoryMapperImpl
import karaokeit.song.split.domain.base.ApiResult
import karaokeit.song.split.domain.model.FactsDomainModel
import karaokeit.song.split.domain.repository.FactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class FactsRepositoryImp @Inject constructor(
    private val factsApi: FactsApi,
    private val mapper: FactsRepositoryMapperImpl
): FactsRepository {

    override suspend fun getCatFacts(): Flow<ApiResult<FactsDomainModel>> {
        return flow {

            try {
                factsApi.getCatFacts().apply {
                    if (isSuccessful) {
                        body()?.let {
                            val data = mapper.toDomainModel(it)
                            emit(ApiResult.Success(data))
                        } ?: emit(ApiResult.Error("Failed"))
                    }
                    emit(ApiResult.Error("Failed"))
                }
            }catch (e:Exception){
                emit(ApiResult.Error("Failed ${e.message}"))
            }

        }
    }

}