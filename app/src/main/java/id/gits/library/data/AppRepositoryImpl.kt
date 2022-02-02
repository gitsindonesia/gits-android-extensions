package id.gits.library.data

import id.gits.library.domain.model.Documentation
import id.gits.library.domain.model.Example
import id.gits.library.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor() : AppRepository {

    override fun getDocumentations(): Flow<Resource<List<Documentation>>> {
        return flow {
            emit(
                Resource.Success(
                    listOf(
                        Documentation(
                            extensionName = "String.isEmailValid()",
                            examples = listOf(
                                Example(
                                    code = "\"sandi@gmail.com\".isEmailValid()",
                                    result = "true",
                                ),
                                Example(
                                    code = "\"sandi@gmail.com\".isEmailValid()",
                                    result = "true",
                                ),
                                Example(
                                    code = "\"sandi@gmail.com\".isEmailValid()",
                                    result = "true",
                                ),
                            ),
                        ),
                        Documentation(
                            extensionName = "String.isEmailValid()",
                            examples = listOf(
                                Example(
                                    code = "\"sandi@gmail.com\".isEmailValid()",
                                    result = "true",
                                ),
                            ),
                        ),
                        Documentation(
                            extensionName = "String.isEmailValid()",
                            examples = listOf(
                                Example(
                                    code = "\"sandi@gmail.com\".isEmailValid()",
                                    result = "true",
                                ),
                                Example(
                                    code = "\"sandi@gmail.com\".isEmailValid()",
                                    result = "true",
                                ),
                            ),
                        ),
                    )
                )
            )
        }
    }
}