package com.ferry.composeui.presentation.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ferry.composeui.domain.model.GameModel
import com.ferry.composeui.presentation.theme.ComposeUITheme

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    game: GameModel = GameModel(),
    onClick: () -> Unit = {},
) {
    Card(
        onClick = onClick,
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black,
        ),
        shape = RoundedCornerShape(
            corner = CornerSize(size = 8.dp),
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
        ),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Text(
                text = game.name,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = game.price.toString(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameCardPreview() {
    ComposeUITheme {
        GameCard(
            game = GameModel(
                name = "Test",
                price = 100_000_000,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        )
    }
}