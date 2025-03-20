package com.example.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .background(color = Color.LightGray)
            .size(200.dp) //root will ignore with width height...
            .padding(20.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(
                    border = BorderStroke(4.dp, Color.Blue),
                    shape = RoundedCornerShape(30.dp)
                )
                .clip(  // bo cac goc
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 20.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 40.dp
                    )
                )
                .background(Color.Red),   //set background sau khi bo goc
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .size(100.dp)
                    .shadow(
                        50.dp,
                        RoundedCornerShape(10.dp),
                        spotColor = Color.Green,
                        ambientColor = Color.Green
                    )
                    .background(Color.White)
            )
            Box(
                Modifier
                    .size(50.dp)
                    .background(Color.Yellow)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}