package id.gits.library.presenter.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gits.library.data.Resource
import id.gits.library.domain.model.Documentation
import id.gits.library.domain.usecase.AppUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: AppUseCase
) : ViewModel() {

    private val _documentations = MutableLiveData<Resource<List<Documentation>>>()
    val documentations = Transformations.map(_documentations) { it }

    fun loadDocumentations() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getDocumentations().collect {
                _documentations.postValue(it)
            }
        }
    }
}