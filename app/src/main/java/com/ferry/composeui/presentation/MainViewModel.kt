package com.ferry.composeui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ferry.composeui.data.repository.GameRepositoryImpl
import com.ferry.composeui.domain.model.GameModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val gameRepository: GameRepositoryImpl,
): ViewModel() {
    private val _gameListState = MutableStateFlow(listOf<GameModel>())
    val gameListState: StateFlow<List<GameModel>> = _gameListState

    init {
        viewModelScope.launch {
            val result = gameRepository.getGameList()
            _gameListState.value = result
        }
    }
}