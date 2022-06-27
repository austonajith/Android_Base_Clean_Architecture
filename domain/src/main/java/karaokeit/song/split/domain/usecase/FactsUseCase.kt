package karaokeit.song.split.domain.usecase

import karaokeit.song.split.domain.base.ApiResult
import karaokeit.song.split.domain.model.FactsDomainModel
import karaokeit.song.split.domain.repository.FactsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface FactsUseCase {
    suspend fun execute(): Flow<ApiResult<FactsDomainModel>>
}

class FactsUseCaseImpl @Inject constructor(
    private val factsRepository: FactsRepository
    ): FactsUseCase {

    override suspend fun execute(): Flow<ApiResult<FactsDomainModel>> {
        return factsRepository.getCatFacts()
    }
}