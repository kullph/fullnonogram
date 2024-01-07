package sf333.finalproject.fullnonogram.page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import sf333.finalproject.fullnonogram.GameViewModel
import sf333.finalproject.fullnonogram.ui.theme.MinecraftFontFamily

@Composable
fun MenuPage(
    navController: NavHostController,
    viewModel: GameViewModel
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Select Level",
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MinecraftFontFamily,
            modifier = Modifier.padding(top = 30.dp)
        )
        Text(
            text = "Your current level: ${viewModel.playerLevel}",
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = MinecraftFontFamily,
            modifier = Modifier.padding(top = 25.dp)
        )
        val numbers = (1..21).toList()
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)

        ) {
            val chunkedNumbers = numbers.chunked(5)

            for (chunk in chunkedNumbers) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                ) {
                    for (number in chunk) {
                        Button(
                            onClick = {
                                viewModel.gameReset()
                                if(number == 21){
                                    viewModel.playerHeart = 1
                                    runBlocking {
                                        delay(500)
                                    }
                                }
                                if(viewModel.playerLevel >= number){
                                    navController.navigate("Screen$number")
                                }

                            },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                                .padding(top = 5.dp, end = 5.dp)
                                .background(Color.White)
                                .clickable {
                                    navController.navigate("Screen$number")
                                },
                            colors = ButtonDefaults.buttonColors(if (viewModel.playerLevel >= number) Color(0xFFFFFedc2ef) else Color.White),

                        ) {
                            Text(text = if (viewModel.playerLevel >= number) String.format("%d", number) else if ( viewModel.playerLevel < number) "X" else if (number == 21) "RANDOM ABYSS!!" else "0" ,
                                fontFamily = MinecraftFontFamily
                            )
                        }
                        Spacer(modifier = Modifier.width(1.dp))
                    }
                }
            }
        }
        Button(
            onClick = {
                navController.navigate("title_Screen")
            },
            modifier = Modifier
                   .offset(y = (100).dp),
            colors =  ButtonDefaults.buttonColors(Color(0xFFFF69B4)),

        ) {
            Text(
                text = "Exit",
                fontSize = 15.sp,
                fontFamily = MinecraftFontFamily
            )
        }
    }
}