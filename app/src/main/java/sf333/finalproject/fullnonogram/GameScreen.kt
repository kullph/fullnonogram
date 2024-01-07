package sf333.finalproject.fullnonogram

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import sf333.finalproject.fullnonogram.page.GamePage
import sf333.finalproject.fullnonogram.page.MenuPage
import sf333.finalproject.fullnonogram.page.TitlePage

@Composable
fun GameScreen(
    viewModel: GameViewModel
){
    var screenNumber = viewModel.screenNumber
    PageSelector(screenNumber,viewModel)
}

@Composable
fun PageSelector(screenNumber:Int,viewModel:GameViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "title_Screen"){
        composable("title_Screen"){
            SelectTitlePage(navController = navController)
        }
        composable("menu_Screen"){
            SelectMenuPage(navController = navController,viewModel=viewModel)
        }
            composable("game_Screen"){
                SelectGamePage(navController = navController,screenNumber,viewModel)
            }
            for (i in 1..30) {
                val screenName = "Screen$i"
                composable(screenName) {
                    GamePage(navController = navController, screenNumber = i,viewModel=viewModel)
                }
            }
    }
}

@Composable
fun SelectTitlePage(navController: NavHostController) {
    TitlePage(navController = navController)
}

@Composable
fun SelectMenuPage(
    navController: NavHostController,
    viewModel: GameViewModel
) {
    MenuPage(navController = navController,viewModel=viewModel)
}

@Composable
fun SelectGamePage(
    navController: NavHostController,
    screenNumber: Int,
    viewModel: GameViewModel
) {
    GamePage(navController = navController, screenNumber,viewModel=viewModel)
}
