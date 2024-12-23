package com.ferry.composeui.domain.repository

import com.ferry.composeui.domain.model.GameModel

interface GameRepository {
    suspend fun getGameList(): List<GameModel>
}