package com.example.check.display

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.check.display.ui.theme.CheckDisplayTheme
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(displayMetrics)

        setContent {
            CheckDisplayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayInfo(displayMetrics)
                }
            }
        }
    }
}

@Composable
fun DisplayInfo(metrics: DisplayMetrics, modifier: Modifier = Modifier) {
    val INCH_TO_MM = 25.4f
    val widthPixels = metrics.widthPixels
    val heightPixels = metrics.heightPixels
    val widthInch = widthPixels / metrics.xdpi
    val heightInch = heightPixels / metrics.ydpi
    val widthMM = widthInch *INCH_TO_MM
    val heightMM = heightInch * INCH_TO_MM
    //c^2 = a^2 + b^2
    val diagonalInch = sqrt(widthInch.pow(2f) + heightInch.pow(2f))
    val diagonalTxt = "%.1f".format(diagonalInch)

    Box(modifier = modifier.padding(20.dp), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = "width Pixels= $widthPixels")
            Text(text = "height Pixels= $heightPixels")
            Text(text = "width dpi= ${metrics.xdpi}")
            Text(text = "height dpi= ${metrics.ydpi}")
            Text(text = "width Inches= $widthInch")
            Text(text = "height Inches= $heightInch")
            Text(text = "width mm= $widthMM")
            Text(text = "height mm= $heightMM")


        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Diagonal",
            )

            Text(
                text = diagonalTxt,
                fontSize = 160.sp,
            )
        }
    }

}

