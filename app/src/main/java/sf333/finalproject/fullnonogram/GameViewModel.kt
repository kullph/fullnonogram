package sf333.finalproject.fullnonogram

import android.app.GameState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import sf333.finalproject.fullnonogram.ui.theme.MinecraftFontFamily


class GameViewModel: ViewModel(){
//    val level = arrayListOf(
//        arrayListOf(
//            arrayListOf(1, 1),
//            arrayListOf(1, 0)
//        ),
//        arrayListOf(
//            arrayListOf(0, 1),
//            arrayListOf(1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(0, 1),
//            arrayListOf(1, 0)
//        ),
//        arrayListOf(
//            arrayListOf(1, 1),
//            arrayListOf(1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(0, 1, 0),
//            arrayListOf(1, 1, 1),
//            arrayListOf(1, 1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(0, 1, 0),
//            arrayListOf(0, 1, 1),
//            arrayListOf(0, 1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(1, 1, 1),
//            arrayListOf(1, 0, 1),
//            arrayListOf(1, 1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(1, 1, 0),
//            arrayListOf(0, 0, 0),
//            arrayListOf(0, 1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(1, 0, 1, 0),
//            arrayListOf(1, 1, 1, 1),
//            arrayListOf(0, 1, 1, 1),
//            arrayListOf(0, 0, 1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(0, 0, 0, 1),
//            arrayListOf(0, 0, 1, 1),
//            arrayListOf(0, 1, 1, 1),
//            arrayListOf(1, 1, 1, 1)
//        ),
//        arrayListOf(
//            arrayListOf(0, 1, 1, 0),
//            arrayListOf(1, 0, 0, 1),
//            arrayListOf(1, 1, 1, 1),
//            arrayListOf(1, 0, 0, 1)
//        ),
//
//        arrayListOf(
//            arrayListOf(0, 1, 1, 1),
//            arrayListOf(1, 0, 0, 1),
//            arrayListOf(1, 0, 0, 1),
//            arrayListOf(0, 1, 1, 0)
//        ),
//
//        arrayListOf(
//            arrayListOf(0, 0, 1, 0, 0),
//            arrayListOf(1, 1, 1, 1, 1),
//            arrayListOf(0, 0, 1, 0, 0),
//            arrayListOf(0, 0, 1, 0, 0),
//            arrayListOf(0, 0, 1, 0, 0)
//        ),
//        arrayListOf(
//            arrayListOf(1, 1, 1, 1, 1),
//            arrayListOf(1, 0, 1, 0, 1),
//            arrayListOf(1, 1, 1, 1, 1),
//            arrayListOf(1, 1, 1, 1, 1),
//            arrayListOf(0, 1, 0, 1, 0)
//        ),
//        arrayListOf(
//            arrayListOf(1, 1, 1, 1, 1),
//            arrayListOf(1, 0, 1, 0, 1),
//            arrayListOf(1, 1, 1, 1, 1),
//            arrayListOf(0, 1, 1, 1, 0),
//            arrayListOf(1, 0, 0, 0, 1)
//        ),
//        arrayListOf(
//            arrayListOf(0, 0, 0, 0, 0, 1),
//            arrayListOf(0, 1, 0, 1, 0, 0),
//            arrayListOf(0, 0, 0, 0, 0, 0),
//            arrayListOf(0, 0, 0, 0, 0, 1),
//            arrayListOf(1, 0, 0, 0, 1, 1),
//        ),
//        arrayListOf(
//            arrayListOf(1, 1, 0, 1, 1, 1),
//            arrayListOf(1, 0, 0, 0, 1, 1),
//            arrayListOf(0, 0, 0, 0, 0, 1),
//            arrayListOf(1, 1, 0, 1, 1, 0),
//            arrayListOf(1, 1, 0, 1, 1, 0),
//            arrayListOf(1, 1, 0, 1, 1, 0)
//        ),
//        arrayListOf(
//            arrayListOf(0, 0, 0, 1, 0, 1),
//            arrayListOf(0, 0, 1, 0, 0, 0),
//            arrayListOf(0, 0, 1, 0, 0, 1),
//            arrayListOf(1, 0, 1, 0, 1, 0),
//            arrayListOf(0, 1, 1, 1, 0, 1),
//            arrayListOf(0, 0, 1, 0, 0, 0)
//        ),
//        arrayListOf(
//            arrayListOf(0, 0, 0, 0, 0, 1),
//            arrayListOf(0, 0, 1, 0, 0, 0),
//            arrayListOf(0, 0, 1, 0, 0, 1),
//            arrayListOf(0, 0, 1, 0, 0, 1),
//            arrayListOf(0, 1, 0, 1, 0, 1),
//            arrayListOf(0, 0, 0, 0, 0, 1),
//        ),
//        arrayListOf(
//            arrayListOf(0, 0, 0, 0, 0, 0),
//            arrayListOf(0, 1, 0, 1, 0, 1),
//            arrayListOf(0, 0, 0, 0, 0, 0),
//            arrayListOf(0, 0, 1, 0, 0, 1),
//            arrayListOf(0, 1, 0, 1, 0, 0),
//            arrayListOf(0, 1, 0, 1, 0, 0)
//        )
//    )

    val level1 = arrayListOf(
        arrayListOf(1, 1),
        arrayListOf(1, 0)
    )

    val level2 = arrayListOf(
        arrayListOf(0, 1),
        arrayListOf(1, 1)
    )

    val level3 = arrayListOf(
        arrayListOf(0, 1),
        arrayListOf(1, 0)
    )
    val level4 = arrayListOf(
        arrayListOf(1, 1),
        arrayListOf(1, 1)
    )

    val level5 = arrayListOf(
        arrayListOf(0, 1, 0),
        arrayListOf(1, 1, 1),
        arrayListOf(1, 1, 1)
    )

    val level6 = arrayListOf(
        arrayListOf(0, 1, 0),
        arrayListOf(0, 1, 1),
        arrayListOf(0, 1, 1)
    )

    val level7 = arrayListOf(
        arrayListOf(1, 1, 1),
        arrayListOf(1, 0, 1),
        arrayListOf(1, 1, 1)
    )

    val level8 = arrayListOf(
        arrayListOf(1, 1, 0),
        arrayListOf(0, 0, 0),
        arrayListOf(0, 1, 1)
    )

    val level9 = arrayListOf(
        arrayListOf(1, 0, 1, 0),
        arrayListOf(1, 1, 1, 1),
        arrayListOf(0, 1, 1, 1),
        arrayListOf(0, 0, 1, 1)
    )

    val level10 = arrayListOf(
        arrayListOf(0, 0, 0, 1),
        arrayListOf(0, 0, 1, 1),
        arrayListOf(0, 1, 1, 1),
        arrayListOf(1, 1, 1, 1)
    )

    val level11 = arrayListOf(
        arrayListOf(0, 1, 1, 0),
        arrayListOf(1, 0, 0, 1),
        arrayListOf(1, 1, 1, 1),
        arrayListOf(1, 0, 0, 1)
    )

    val level12 = arrayListOf(
        arrayListOf(0, 1, 1, 1),
        arrayListOf(1, 0, 0, 1),
        arrayListOf(1, 0, 0, 1),
        arrayListOf(0, 1, 1, 0)
    )

    val level13 = arrayListOf(
        arrayListOf(0, 0, 1, 0, 0),
        arrayListOf(1, 1, 1, 1, 1),
        arrayListOf(0, 0, 1, 0, 0),
        arrayListOf(0, 0, 1, 0, 0),
        arrayListOf(0, 0, 1, 0, 0)
    )

    val level14 = arrayListOf(
        arrayListOf(1, 1, 1, 1, 1),
        arrayListOf(1, 0, 1, 0, 1),
        arrayListOf(1, 1, 1, 1, 1),
        arrayListOf(1, 1, 1, 1, 1),
        arrayListOf(0, 1, 0, 1, 0)
    )

    val level15 = arrayListOf(
        arrayListOf(1, 1, 1, 1, 1),
        arrayListOf(1, 0, 1, 0, 1),
        arrayListOf(1, 1, 1, 1, 1),
        arrayListOf(0, 1, 1, 1, 0),
        arrayListOf(1, 0, 0, 0, 1)
    )

    val level16 = arrayListOf(
        arrayListOf(0, 0, 0, 0, 0, 1),
        arrayListOf(0, 1, 0, 1, 0, 0),
        arrayListOf(0, 0, 0, 0, 0, 0),
        arrayListOf(0, 0, 0, 0, 0, 1),
        arrayListOf(1, 0, 0, 0, 1, 1),
    )

    val level17 = arrayListOf(
        arrayListOf(1, 1, 0, 1, 1, 1),
        arrayListOf(1, 0, 0, 0, 1, 1),
        arrayListOf(0, 0, 0, 0, 0, 1),
        arrayListOf(1, 1, 0, 1, 1, 0),
        arrayListOf(1, 1, 0, 1, 1, 0),
        arrayListOf(1, 1, 0, 1, 1, 0)
    )

    val level18 = arrayListOf(
        arrayListOf(0, 0, 0, 1, 0, 1),
        arrayListOf(0, 0, 1, 0, 0, 0),
        arrayListOf(0, 0, 1, 0, 0, 1),
        arrayListOf(1, 0, 1, 0, 1, 0),
        arrayListOf(0, 1, 1, 1, 0, 1),
        arrayListOf(0, 0, 1, 0, 0, 0)
    )

    val level19 = arrayListOf(
        arrayListOf(0, 0, 0, 0, 0, 1),
        arrayListOf(0, 0, 1, 0, 0, 0),
        arrayListOf(0, 0, 1, 0, 0, 1),
        arrayListOf(0, 0, 1, 0, 0, 1),
        arrayListOf(0, 1, 0, 1, 0, 1),
        arrayListOf(0, 0, 0, 0, 0, 1),
    )

    val level20 = arrayListOf(
        arrayListOf(0, 0, 0, 0, 0, 0),
        arrayListOf(0, 1, 0, 1, 0, 1),
        arrayListOf(0, 0, 0, 0, 0, 0),
        arrayListOf(0, 0, 1, 0, 0, 1),
        arrayListOf(0, 1, 0, 1, 0, 0),
        arrayListOf(0, 1, 0, 1, 0, 0)
    )

    var playerLevel by mutableIntStateOf(1)
    var playerHeart by mutableIntStateOf(3)
    var levelSelected: List<List<Int>> = arrayListOf(
        arrayListOf(0, 0),
        arrayListOf(0, 0)
    )
    var screenNumber: Int = 0
    var isFailed by mutableStateOf(false)
    var isWin by mutableStateOf(false)
    var tempClickedList: Array<Array<Int>> = Array(2) { Array(2) { 0 } }

    fun gameReset() {
        playerHeart = 3
        isFailed = false
        isWin = false
        tempClickedList = Array(levelSelected.size) { Array(levelSelected.size) { 0 } }
    }

    fun createHint(
        level: List<List<Int>>
    ): Pair<MutableList<MutableList<Int>>, MutableList<MutableList<Int>>>
    {
        val rowHints: MutableList<MutableList<Int>> = mutableListOf()
        val colHints: MutableList<MutableList<Int>> = MutableList(level[0].size) { mutableListOf() }

        // Calculate hints for rows
        for (i in level.indices) {
            var rowCount = 0
            val rowTempList: MutableList<Int> = mutableListOf()

            for (j in level[i].indices) {
                if (level[i][j] == 1) {
                    rowCount++
                } else if (rowCount > 0) {
                    rowTempList.add(rowCount)
                    rowCount = 0
                }
            }
            if (rowCount > 0) {
                rowTempList.add(rowCount)
            }
            rowHints.add(rowTempList)
        }

        for (i in level[0].indices) {
            var colCount = 0
            val colTempList: MutableList<Int> = mutableListOf()

            for (j in level.indices) {
                if (level[j][i] == 1) {
                    colCount++
                } else if (colCount > 0) {
                    colTempList.add(colCount)
                    colCount = 0
                }
            }
            if (colCount > 0) {
                colTempList.add(colCount)
            }
            colHints[i] = colTempList
        }

        return Pair(rowHints, colHints)
    }

    @Composable
    fun CreateBoard(
        level: List<List<Int>>,
        modifier: Modifier = Modifier
    ) {
        val hintsPair = createHint(level)
        val rowHints = hintsPair.first
        val colHints = hintsPair.second
        tempClickedList = Array(level.size) { Array(level.size) { 0 } }

        Column (
            modifier = Modifier
                .border(1.dp, Color.Transparent)
        ){
            Row (
                modifier = Modifier
                    .border(1.dp, Color.Transparent)
            ){
                Column (
                    modifier = Modifier
                        .width(300.dp/level.size)
                ) {}
                Column (
                    modifier = Modifier
                ){
                    LazyRow(
                        modifier = Modifier
                    ) {
                        items(colHints) { col ->
                            LazyColumn(
                                modifier = Modifier
                                    .border(1.dp, Color.Transparent)
                                    .width(300.dp / level.size)
                            ){
                                items(col) { item ->
                                    Text(text = " $item",
                                        fontFamily = MinecraftFontFamily,
                                        modifier = Modifier.padding(0.5.dp))
                                }
                            }
                        }
                    }
                }
            }
            Row (
                modifier = Modifier
                    .border(1.dp, Color.Transparent)
            ){
                LazyColumn (
                    modifier = Modifier
                        .width(300.dp / level.size)
                ){
                    items(rowHints) { row ->
                        LazyRow (
                            modifier = Modifier
                                .height(300.dp / level.size)
                        ){
                            items(row) { item ->
                                Text(text=" $item",
                                    fontFamily = MinecraftFontFamily,
                                    modifier = Modifier.padding(0.5.dp))
                            }
                        }
                    }
                }
                Column (
                    modifier = Modifier
                        .border(1.dp, Color.Transparent)
                        .height(300.dp)
                ){
                    Box(
                        modifier = Modifier
                            .border(1.dp, Color.Transparent)
                            .size(width = 300.dp, height = 300.dp)
                    ) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(level.size),
                            modifier = modifier,
                            contentPadding = PaddingValues(5.dp),
                            verticalArrangement = Arrangement.spacedBy(3.dp),
                            horizontalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            itemsIndexed(level.flatten()) { index, cell ->
                                CreateCell(
                                    idx = (index / level.size).toString() + (index % level.size).toString(),
                                    ans = cell,
                                    level = level
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun CreateCell(
        idx: String,
        ans: Int,
        level: List<List<Int>>
    ) {
        var isClicked by remember { mutableStateOf(false) }
        var heartPrevent by remember { mutableStateOf(true) }
        Box(
            modifier = Modifier
                .clickable {
                    isClicked = true
                }
                .background(
                    color = if (isClicked) Color.Transparent else Color.White,
                    shape = RoundedCornerShape(14.dp)
                )
                .aspectRatio(1f)
        ) {
            if (isClicked && !isFailed && !isWin) {
                tempClickedList[Character.getNumericValue(idx[0])][Character.getNumericValue(idx[1])] = 1
                Cross()
                if (ans == 0 &&
                    tempClickedList[Character.getNumericValue(idx[0])][Character.getNumericValue(idx[1])] == 1 &&
                    heartPrevent
                ) {
                    playerHeart -= 1
                    heartPrevent = false

                } else if (ans == 1 && tempClickedList[Character.getNumericValue(idx[0])][Character.getNumericValue(idx[1])] == 1
                ) {
                    Filled()
                }
                if (playerHeart <= 0) {
                    isFailed = true
                }
                if (checkWin()) {
                    isWin = true
                }
            }
//            for (i in 0..<level.size) {
//                var horizontalScore = 0
//                var verticalScore = 0
//
//                for (j in 0..<level.size){
//                    if (level[i][j] == 1 && tempClickedList[i][j] == 0){
//                        horizontalScore -= 1
//                    }
//
//                    if (level[j][i] == 1 && tempClickedList[j][i] == 0){
//                        verticalScore -= 1
//                    }
//                }
//
//                if (horizontalScore >= 0) {
//                    tempClickedList[i] = Array(level.size) { 1 }
//                }
//                if (verticalScore >= 0){
//                    for (j in 0..<level.size){
//                        tempClickedList[j][i] = 1
//                    }
//                }
//            }
        }
    }

    fun checkWin():Boolean {
        if(playerHeart >= 0){
            for (i in 0.. levelSelected.size-1){
                for (j in 0.. levelSelected.size-1){
                    if (levelSelected[i][j] == 1 &&levelSelected[i][j] != tempClickedList[i][j]) {
                        return false
                    }
                }
            }
            return true
        }
        else{
            return false
        }
    }

    @Composable
    public fun GameSetup() {
        CreateBoard(levelSelected)
    }

    fun randomLevel():List<List<Int>>{
        val randomSize = (6..10).random()

        val randomArray = List(randomSize) {
            List(randomSize) {
                (0..1).random()
            }
        }

        return randomArray
    }

    public fun levelSetup(screenNumber: Int) {
        levelSelected = when (screenNumber) {
            1 -> level1
            2 -> level2
            3 -> level3
            4 -> level4
            5 -> level5
            6 -> level6
            7 -> level7
            8 -> level8
            9 -> level9
            10 -> level10
            11 -> level11
            12 -> level12
            13 -> level13
            14 -> level14
            15 -> level15
            16 -> level16
            17 -> level17
            18 -> level18
            19 -> level19
            20 -> level20
            21 -> randomLevel()

            else -> level1
        }
    }
}