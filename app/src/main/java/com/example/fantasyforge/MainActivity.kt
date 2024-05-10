package com.example.fantasyforge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fantasyforge.screens.CharacterSheetsScreen
import com.example.fantasyforge.screens.CreateCharacterSheetScreen
import com.example.fantasyforge.screens.DiceRollerScreen
import com.example.fantasyforge.screens.GameMasterScreen
import com.example.fantasyforge.screens.NameGeneratorScreen
import com.example.fantasyforge.screens.PlayerScreen
import com.example.fantasyforge.screens.QuestGeneratorScreen
import com.example.fantasyforge.screens.RelicGeneratorScreen
import com.example.fantasyforge.screens.SearchScreen
import com.example.fantasyforge.screens.TownGeneratorScreen
import com.example.fantasyforge.ui.theme.FantasyForgeTheme
import com.example.fantasyforge.viewmodel.SearchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FantasyForgeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "mainMenuScreen"
                    ) {
                        composable("mainMenuScreen") {
                            MainMenu(navController)
                        }
                        composable("gameMasterScreen") {
                            GameMasterScreen(navController)
                        }
                        composable("townGeneratorScreen") {
                            TownGeneratorScreen()
                        }
                        composable("nameGeneratorScreen") {
                            NameGeneratorScreen()
                        }
                        // Add the composable for the quest generator screen
                        composable("questGeneratorScreen") {
                            QuestGeneratorScreen()
                        }
                        composable("relicGeneratorScreen") {
                            RelicGeneratorScreen()
                        }
                        composable("characterSheetsScreen") {
                            CharacterSheetsScreen(navController)
                        }
                        composable("searchScreen") {
                            val searchViewModel: SearchViewModel = viewModel()
                            SearchScreen(searchViewModel, navController)
                        }
                        composable("createCharacterSheetScreen") {
                            CreateCharacterSheetScreen(navController)
                        }
                        composable("diceRollerScreen") {
                            DiceRollerScreen(navController)
                        }
                        composable("playerScreen") {
                            PlayerScreen(navController)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun MainMenu(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFDF0D5)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left side button for Game Master
        TextButton(
            onClick = {
                // Handle Game Master button click
                // Navigate to the Game Master screen
                navController.navigate("gameMasterScreen")
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(8.dp)
                .background(color = Color(0xFF780000), shape = RoundedCornerShape(8.dp)),
        ) {
            Text(
                text = "Game Master",
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Color(0xFF780000)),
                style = MaterialTheme.typography.displaySmall.copy(
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )
        }

        // Right side button for Players
        TextButton(
            onClick = {
                // Handle Players button click
                // You can navigate to the Players screen or perform other actions
                navController.navigate("PlayerScreen")
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(8.dp)
                .background(color = Color(0xFF003049), shape = RoundedCornerShape(8.dp)),
        ) {
            Text(
                text = "Players",
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = Color(0xFF003049)),
                style = MaterialTheme.typography.displaySmall.copy(
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    val navController = rememberNavController()

    FantasyForgeTheme {
        // Pass the navController to MainMenu
        MainMenu(navController = navController)
    }
}
