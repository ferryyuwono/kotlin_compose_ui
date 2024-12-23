package com.ferry.composeui.data.repository

import com.ferry.composeui.domain.model.GameModel
import com.ferry.composeui.domain.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRepositoryImpl : GameRepository {
    override suspend fun getGameList(): List<GameModel> = withContext(Dispatchers.IO) {
        return@withContext listOf(
            GameModel(
                name = "Test 1",
                price = 100_000_000,
            ),
            GameModel(
                name = "Test 2",
                price = 200_000_000,
            ),
            GameModel(
                name = "Test 3",
                price = 100_000_000,
            ),
            GameModel(
                name = "Test 4",
                price = 200_000_000,
            ),GameModel(
                name = "Test 5",
                price = 100_000_000,
            ),
            GameModel(
                name = "Test 6",
                price = 200_000_000,
            ),
            GameModel(
                name = "Test 7",
                price = 100_000_000,
            ),
            GameModel(
                name = "Test 8",
                price = 200_000_000,
            ),
        )
    }
}