package sf333.finalproject.fullnonogram

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sf333.finalproject.fullnonogram.ui.theme.FullnonogramTheme
@Composable
fun Cross() {
    val color = Color.Red
    val strokeWidth = 20f
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        drawLine(
            color = color,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height)
        )
        drawLine(
            color = color,
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round,
            start = Offset(0f, size.height),
            end = Offset(size.width, 0f)
        )
    }
}

@Composable
fun Filled() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        drawRect(
            color = Color.DarkGray,
            size = Size(size.width, size.height),
            topLeft = Offset(0f, 0f),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CrossPreview() {
    Cross()
}

@Preview(showBackground = true)
@Composable
fun FilledPreview() {
    Filled()
}