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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.ferry.composeui.presentation.compose.GameCard
import com.ferry.composeui.presentation.theme.ComposeUITheme
import com.ferry.composeui.data.repository.GameRepositoryImpl

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
                    GameScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    gameViewModel: MainViewModel = MainViewModel(
        gameRepository = GameRepositoryImpl()
    ),
) {
    val context = LocalContext.current
    val listState = rememberLazyListState()
    val gameUiState by gameViewModel.gameListState.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 8.dp),
        state = listState,
    ) {
        itemsIndexed(gameUiState) { index, game ->
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
            if (index < gameUiState.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameListPreview() {
    ComposeUITheme {
        GameScreen()
    }
}