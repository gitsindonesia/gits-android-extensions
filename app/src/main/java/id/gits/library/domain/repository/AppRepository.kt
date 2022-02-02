package id.gits.library.domain.repository

import id.gits.library.data.Resource
import id.gits.library.domain.model.Documentation
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getDocumentations(): Flow<Resource<List<Documentation>>>
}