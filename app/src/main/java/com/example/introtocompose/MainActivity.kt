package com.example.introtocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    val moneyCounterItem = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxHeight()
            .fillMaxWidth(),
        color = Color(0xFF9ec9cf)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$${moneyCounterItem.value}", style = TextStyle(
                    color = Color.Green,
                    fontSize = 60.sp
                )
            )
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter = moneyCounterItem.value) { newValue ->
                moneyCounterItem.value = newValue
            }
            if (moneyCounterItem.value > 30) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Lots of money", style = TextStyle(
                        color = Color.Gray,
                    )
                )
            }


        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    IntroToComposeTheme {
//
//    }
//}

@Composable
fun CreateCircle(moneyCounter: Int = 0, updateMoneyCounter: (Int) -> Unit) {

    Card(
        modifier = Modifier.padding(3.dp)
            .size(105.dp)
            .clickable {
                updateMoneyCounter(moneyCounter + 1)
            },
        backgroundColor = Color.Red,
        shape = CircleShape,
        elevation = 4.dp
    ) {

        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Tap", style = TextStyle(
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
    }
}
