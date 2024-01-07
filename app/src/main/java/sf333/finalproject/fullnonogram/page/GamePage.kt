package sf333.finalproject.fullnonogram.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import sf333.finalproject.fullnonogram.GameViewModel
import sf333.finalproject.fullnonogram.ui.theme.MinecraftFontFamily

@Composable
fun GamePage(
    navController: NavHostController,
    screenNumber: Int,
    viewModel: GameViewModel
    ) {

    var isWin = viewModel.isWin
    var isFailed = viewModel.isFailed

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFedc2ef))
    ) {
        Text(
            text = "Level $screenNumber",
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MinecraftFontFamily,
            modifier = Modifier.offset(y = (-30).dp)
        )

        Text(
            text = "Heart ${viewModel.playerHeart}",
            color = if(viewModel.playerHeart == 3) Color.White else if(viewModel.playerHeart == 2) Color(0xFFEF6C00) else if(viewModel.playerHeart == 1) Color.Red else Color.Black,
            fontSize = 25.sp,
            fontFamily = MinecraftFontFamily,
            modifier = Modifier.offset(y = (-30).dp)
                .padding(top=25.dp, bottom = 5.dp)
        )

        viewModel.levelSetup(screenNumber)
        viewModel.GameSetup()

        if (isWin && !isFailed){
            if(screenNumber == 21){
                navController.navigate("menu_Screen")
            }
            viewModel.playerLevel = screenNumber+1
            Text(text = "U R SO GOOD!",
                fontFamily = MinecraftFontFamily,
                modifier = Modifier.padding(top=5.dp)
            )
            Button(
                onClick = {
                    viewModel.gameReset()
                    navController.navigate("menu_Screen")
                },
                modifier = Modifier.padding(top = 20.dp),
                colors =  ButtonDefaults.buttonColors(Color(0xFFFF69B4))

            ) {
                Text(text = "Select Level",
                    fontFamily = MinecraftFontFamily
                )
            }
        }
        else if (isFailed && !isWin) {
            if(screenNumber == 21){
                navController.navigate("menu_Screen")
            }
            Text(text = "Nice Try!",
                fontFamily = MinecraftFontFamily,
                modifier = Modifier.padding(top=5.dp)
            )
            Button(
                onClick = {
                    viewModel.gameReset()
                    navController.navigate("menu_Screen")
                },
                modifier = Modifier.padding(top = 20.dp),
                colors =  ButtonDefaults.buttonColors(Color(0xFFFF69B4))

            ) {
                Text(text = "Select Level",
                    fontFamily = MinecraftFontFamily
                )
            }
        }
        else{
            Text(text = "Hmm..",
                fontFamily = MinecraftFontFamily,
                modifier = Modifier.padding(top=5.dp)
            )
            Button(
                onClick = {
                    viewModel.gameReset()
                    navController.navigate("menu_Screen")
                },
                modifier = Modifier.padding(top = 20.dp),
                colors =  ButtonDefaults.buttonColors(Color(0xFFFF69B4))

            ) {
                Text(text = "Select Level",
                    fontFamily = MinecraftFontFamily
                )
            }
        }


    }
}

