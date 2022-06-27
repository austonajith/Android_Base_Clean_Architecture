package karaokeit.song.split.data.mapper

import karaokeit.song.split.data.model.FactsDataModel
import karaokeit.song.split.domain.model.FactsDomainModel


interface FactsRepositoryMapper {
    fun toDomainModel(model: FactsDataModel):FactsDomainModel
}
class FactsRepositoryMapperImpl : FactsRepositoryMapper {

    override fun toDomainModel(model: FactsDataModel):FactsDomainModel {
        return FactsDomainModel(
            fact = model.fact,
            length = model.length
        )
    }

}