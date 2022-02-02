package id.gits.library.di

import dagger.Binds
import dagger.Module
import id.gits.library.data.AppRepositoryImpl
import id.gits.library.domain.repository.AppRepository

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: AppRepositoryImpl): AppRepository
}