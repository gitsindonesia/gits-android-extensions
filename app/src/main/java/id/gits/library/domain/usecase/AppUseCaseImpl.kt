package id.gits.library.domain.usecase

import id.gits.library.data.Resource
import id.gits.library.domain.model.Documentation
import id.gits.library.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppUseCaseImpl @Inject constructor(private val repository: AppRepository) : AppUseCase {

    override fun getDocumentations(): Flow<Resource<List<Documentation>>> =
        repository.getDocumentations()
}