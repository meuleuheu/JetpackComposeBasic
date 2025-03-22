package com.example.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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

// No.2
@Composable
fun Greeting2(name: String, modifier: Modifier) {
//    Box {
//        Row(Modifier
//            .background(color = Color.LightGray)
//            .fillMaxWidth()
//            .height(200.dp)
//            , horizontalArrangement = Arrangement.SpaceBetween
//            , Alignment.CenterVertically
//        ) {
//            BaseItem2(Modifier.background(Color.Red).align(Alignment.Top))
//            BaseItem(Color.Green)
//            BaseItem2(Modifier
//                .background(Color.Blue)
//                .align(Alignment.Bottom)
//                .size(50.dp))
//        }
//    }

    Box {
        Column(Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .height(500.dp)
            , verticalArrangement = Arrangement.SpaceBetween
            , Alignment.CenterHorizontally
        ) {
            BaseItem2(Modifier.background(Color.Red).align(Alignment.Start))
            BaseItem(Color.Green)
            BaseItem2(Modifier
                .background(Color.Blue)
                .align(Alignment.End)
                .size(50.dp))
        }
    }
}

@Composable
fun BaseItem(color: Color) {
    Box(modifier = Modifier
        .size(100.dp)
        .background(color))
}

@Composable
fun BaseItem2(modifier: Modifier) {
    Box(modifier = modifier
        .size(100.dp))
}
// No.2

// No.3
@Composable
fun Greeting3(name: String, modifier: Modifier) {
    Box {
        Row(modifier = Modifier.fillMaxWidth().height(200.dp).background(Color.LightGray)
            , Arrangement.SpaceAround
            , verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(100.dp).background(Color.Red).weight(1f, false))
            Box(Modifier.size(150.dp).background(Color.Green).weight(1f, false))
            Box(Modifier.size(100.dp).background(Color.Blue).weight(1f))
        }
    }
}
// No.3 end

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting3("Android", modifier = Modifier)
        }
    }
}