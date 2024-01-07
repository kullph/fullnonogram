package sf333.finalproject.fullnonogram.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import sf333.finalproject.fullnonogram.R
import sf333.finalproject.fullnonogram.ui.theme.MinecraftFontFamily

@Composable
fun TitlePage(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(500.dp)
                .scale(scaleX = 1.2f, scaleY = 1.2f)
        )
        Button(onClick = {
            navController.navigate("menu_Screen")
        },
            modifier = Modifier.offset(y = (-150).dp),
            colors =  ButtonDefaults.buttonColors(Color(0xFFFFFedc2ef))

        ) {
            Text(
                text = "Enter Game",
                fontSize = 16.sp,
                fontFamily = MinecraftFontFamily
            )
        }

        Text(
            text = "Developed For SF333",
            fontSize = 12.sp,
            fontFamily = MinecraftFontFamily
        )

    }
}