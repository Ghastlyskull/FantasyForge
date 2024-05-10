package com.example.fantasyforge.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.fantasyforge.R

@Composable
fun GameMasterScreen(navController: NavHostController) {
    // Use the same color as on the Menu Screen
    val titleColor = Color(0xFF780000)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        // Background image behind other UI elements
        BackgroundImage()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Game Master",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White // Set the text color to white
                ),
                modifier = Modifier.padding(8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(color = titleColor)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Content specific to the Game Master screen
            Text(
                text = "Welcome, Game Master!",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White // Set the text color to white
                ),
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Content specific to the Game Master screen
            RedButton(
                text = "Name Generator",
                onClick = {
                    // Handle Name Generator button click
                    navController.navigate("nameGeneratorScreen")
                }
            )

            RedButton(
                text = "Town Name Generator",
                onClick = {
                    navController.navigate("townGeneratorScreen")
                }
            )

            RedButton(
                text = "Quest Generator",
                onClick = {
                    navController.navigate("questGeneratorScreen")
                }
            )

            RedButton(
                text = "Relic Generator",
                onClick = {
                    navController.navigate("relicGeneratorScreen")
                }
            )

            RedButton(
                text = "Dice Roller",
                onClick = {
                    navController.navigate("DiceRollerScreen")
                }
            )
        }
    }
}
@Composable
fun RedButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF780000)),
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White
                )
            )
        }
    )
}
@Composable
fun BackgroundImage() {
    // Load your custom background image here
    // You can use Image or CoilImage based on your image loading library
    // Example using Image with a drawable resource
    Image(
        painter = painterResource(id = R.drawable.stellarisphone),
        contentDescription = null, // Decorative content
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}



