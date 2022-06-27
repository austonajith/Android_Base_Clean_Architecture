package karaokeit.song.split.domain.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import karaokeit.song.split.domain.repository.FactsRepository
import karaokeit.song.split.domain.usecase.FactsUseCase
import karaokeit.song.split.domain.usecase.FactsUseCaseImpl


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Reusable
    fun provideGetFactsUseCase(
        factsRepository: FactsRepository
    ): FactsUseCase = FactsUseCaseImpl(factsRepository)


}