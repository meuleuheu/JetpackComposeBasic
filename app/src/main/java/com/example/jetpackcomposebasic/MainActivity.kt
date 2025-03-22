package com.example.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

// No.4
@Composable
fun Greeting4_1(name: String, modifier: Modifier) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Row(Modifier.horizontalScroll(rememberScrollState())) {
            repeat(10) {
                Box(Modifier.size(100.dp).padding(10.dp).background(Color.Green))
            }
        }

        repeat(10) {
            Box(Modifier.size(100.dp).padding(10.dp).background(Color.Green))
        }

        Row(Modifier.horizontalScroll(rememberScrollState())) {
            repeat(10) {
                Box(Modifier.size(100.dp).padding(10.dp).background(Color.Green))
            }
        }
    }
}

@Composable
fun Greeting4_2(name: String, modifier: Modifier) {
    var offset by remember { mutableStateOf(0f) }
    Column (
        Modifier.scrollable(
            orientation = Orientation.Vertical,
            state = rememberScrollableState { delta ->
                offset += delta
                delta
            }
        )){
        Text("$offset")
    }
}
// No.4 end

// No.5
val playfairFont = FontFamily(
    Font(R.font.playfair_display_medium, weight = FontWeight.Medium),
    Font(R.font.playfair_display_bold_italic, weight = FontWeight.Bold,
        style = FontStyle.Italic
    )
)
@Composable
fun Greeting5(name: String, modifier: Modifier) {
    Box {
//        Text("Ngay mai ra sao chang ai biet truoc" +
//        "nen moi khi co co hoi" +
//        "toi deu muon ngam nhin ban lau hon mot chut",
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Green)) {
                    append("He")
                }
                append("llo")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append(" Wor")
                }
                append("ld")
            },
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            //softWrap = false,   //ko muon xuong dong
            fontSize = 40.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = modifier.background(Color.Yellow)
//                .rotate(90f)
        )
    }
}
// No.5 end

// No.6
@Composable
fun Greeting6(name: String, modifier: Modifier) {
    Column {
        Button(onClick = {/* TODO */}, border = BorderStroke(2.dp, color = Color.Red),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text("Button")
            Icon(Icons.Filled.Favorite, "Favorite")
        }
        FilledTonalButton(onClick = { /* TODO */}, contentPadding = PaddingValues(30.dp), enabled = false) {
            Text("FilledTonalButton")
        }
        ElevatedButton(onClick = {/* TODO */}, elevation = ButtonDefaults.buttonElevation(defaultElevation = 20.dp)) {
            Text("ElevatedButton")
        }
        OutlinedButton(onClick = { /* TODO */},
            shape = CutCornerShape(15.dp) //RoundedCornerShape(10.dp), RectangleShape
        ) {
            Text("OutlinedButton")
        }
        TextButton(onClick = { /* TODO */},
            modifier = Modifier.shadow(elevation = 2.dp, shape = CircleShape)) {
            Text("TextButton")
        }
        IconButton(onClick = { /* TODO */}) {
            Icon(Icons.Filled.Favorite, "Favorite")
        }
    }
}
// No.6 end

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting6("Android", modifier = Modifier)
        }
    }
}