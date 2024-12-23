package com.ferry.composeui.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ferry.composeui.domain.model.GameModel
import com.ferry.composeui.presentation.compose.GameCard
import com.ferry.composeui.presentation.theme.ComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            val focusManager = LocalFocusManager.current

            ComposeUITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = Color.White,
                                )
                                .padding(horizontal = 8.dp)
                        ) {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = text,
                                label = {
                                    Text(
                                        text = "Search"
                                    )
                                },
                                onValueChange = {
                                    text = it
                                },
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    imeAction = ImeAction.Done,
                                    keyboardType = KeyboardType.Text,
                                ),
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()
                                    }
                                ),
                            )
                        }
                    },
                    bottomBar = {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 0.dp,
                                    start = 8.dp,
                                    end = 8.dp,
                                    bottom = 8.dp,
                                ),
                            onClick = {
                                focusManager.clearFocus()
                            },
                        ) {
                            Text(
                                "OK",
                                modifier = Modifier.padding(all = 8.dp),
                            )
                        }
                    },
                ) { innerPadding ->
                    GameList(
                        games = listOf(
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                            GameModel(
                                name = "Test",
                                price = 100_000_000,
                            ),
                            GameModel(
                                name = "Test 2",
                                price = 200_000_000,
                            ),
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GameList(
    modifier: Modifier = Modifier,
    games: List<GameModel> = listOf(),
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 8.dp)
    ) {
        LazyColumn {
            itemsIndexed(games) { index, game ->
                GameCard(
                    modifier = Modifier.fillMaxWidth(),
                    game = game,
                    onClick = {
                        Toast.makeText(
                            context,
                            "${game.name} Clicked",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                )
                if (index < games.lastIndex) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameListPreview() {
    ComposeUITheme {
        GameList(
            games = listOf(
                GameModel(
                    name = "Test",
                    price = 100_000_000,
                ),
                GameModel(
                    name = "Test 2",
                    price = 200_000_000,
                ),
            ),
        )
    }
}