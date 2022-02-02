package id.gits.library.di

import dagger.Binds
import dagger.Module
import id.gits.library.domain.usecase.AppUseCase
import id.gits.library.domain.usecase.AppUseCaseImpl

@Module
abstract class AppModule {

    @Binds
    abstract fun provideUseCase(useCase: AppUseCaseImpl): AppUseCase
}