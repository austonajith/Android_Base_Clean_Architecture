package karaokeit.song.split.data

import retrofit2.Response
import retrofit2.http.GET

interface FactsApi {
    @GET("/fact")
    suspend fun getCatFacts(): Response<FactsDataModel>
}