package com.kraigdev.livecoding.modules.Main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kraigdev.livecoding.modules.Main.domain.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val coroutineDispatcher: CoroutineDispatcher
): ViewModel() {

    private var _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun getCategories() {
        getCategoriesUseCase().map {
            _state.value = _state.value.copy(categoryList = it.categoryList)
        }.flowOn(coroutineDispatcher).launchIn(viewModelScope)
    }

    data class UiState(
        val categoryList: List<String> = listOf()
    )

}