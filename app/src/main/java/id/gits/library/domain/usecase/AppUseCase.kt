package id.gits.library.domain.usecase

import id.gits.library.data.Resource
import id.gits.library.domain.model.Documentation
import kotlinx.coroutines.flow.Flow

interface AppUseCase {

    fun getDocumentations(): Flow<Resource<List<Documentation>>>
}