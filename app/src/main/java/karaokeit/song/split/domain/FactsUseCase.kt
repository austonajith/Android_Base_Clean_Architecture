package karaokeit.song.split.domain

import karaokeit.song.split.data.FactsApi
import karaokeit.song.split.data.FactsDataModel
import karaokeit.song.split.presentation.State
import karaokeit.song.split.utils.ErrorUtils
import karaokeit.song.split.utils.ErrorUtils.Companion.DEFAULT_NETWORK_ERROR
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class FactsUseCase
@Inject constructor(private val factsApi: FactsApi) {

    suspend fun getFacts(): Flow<State<FactsDataModel>> {
        return flow {
            emit(State.Loading)
            try {
                val response = factsApi.getCatFacts()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(State.Success(it))
                        Timber.v(it.toString())
                    } ?: kotlin.run {
                        emit(State.Error(Throwable(DEFAULT_NETWORK_ERROR)))
                        Timber.e(DEFAULT_NETWORK_ERROR)
                    }
                } else {
                    emit(State.Error(Throwable(DEFAULT_NETWORK_ERROR)))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ErrorUtils.resolveError(e))
                Timber.e(e)
            }
        }
    }
}