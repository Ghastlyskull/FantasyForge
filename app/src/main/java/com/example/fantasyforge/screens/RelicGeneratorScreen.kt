package com.example.fantasyforge.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fantasyforge.ui.theme.FantasyForgeTheme

@Composable
fun RelicGeneratorScreen() {
    var relicName by remember { mutableStateOf("") }
    var relicDescription by remember { mutableStateOf("") }

    FantasyForgeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Red banner on top
            // Banner at the top of the screen
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                color = Color(0xFF780000),
            ) {
                Text(
                    text = "Fantasy Forge Relic Generator",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }


            Spacer(modifier = Modifier.height(32.dp))

            // Button to generate relic
            Button(
                onClick = {
                    val relic = generateRelic()
                    relicName = relic.first
                    relicDescription = relic.second
                },
                shape = RoundedCornerShape(50), // Circular shaped buttons
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF780000)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Generate Relic",
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Displaying relic name and description
            if (relicName.isNotEmpty()) {
                Text(
                    text = "Relic Name: $relicName",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Description: $relicDescription",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Placeholder function for relic generation logic with description
fun generateRelic(): Pair<String, String> {
    val relics = listOf(
        Pair("Amulet of Courage", "Grants bravery to the wearer in the face of danger."),
        Pair("Sword of Destiny", "Destined for the chosen one, this sword can vanquish any evil."),
        Pair("Crown of Wisdom", "Bestows supernatural wisdom upon its bearer."),
        Pair("Orb of Storms", "Controls the weather, summoning storms at will."),
        Pair("Tome of Ancient Secrets", "Contains knowledge forgotten by time."),
        Pair("Shield of Valor", "Protects the bearer against attacks from foes."),
        Pair("Chalice of Purity", "Cures any poison when drunk from."),
        Pair("Lantern of Revealing", "Illuminates hidden truths and secrets."),
        Pair("Ring of Invisibility", "Renders the wearer unseen to the naked eye."),
        Pair("Robes of the Magi", "Increases the power of magical spells."),
        Pair("Boots of Swiftness", "Allows the wearer to move like the wind."),
        Pair("Gloves of Thievery", "Enhances dexterity and lockpicking skills."),
        Pair("Helm of Comprehension", "Enables the understanding of any language."),
        Pair("Belt of Giant Strength", "Gives the wearer the strength of a giant."),
        Pair("Mantle of the Phoenix", "Allows the user to rise from defeat, rejuvenated."),
        Pair("Bracers of Archery", "Grants unmatched skill in archery."),
        Pair("Cloak of the Bat", "Bestows the ability to move silently in the shadows."),
        Pair("Gauntlets of Ogre Power", "Grants immense strength to the bearer."),
        Pair("Medallion of Thoughts", "Allows the reading of surface thoughts."),
        Pair("Wand of Fireballs", "Launches balls of fire that explode upon impact.")
    )
    return relics.random()
}

@Preview(showBackground = true)
@Composable
fun RelicGeneratorScreenPreview() {
    RelicGeneratorScreen()
}