package com.example.jetpackcomposebasic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.sharp.Delete
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select
import java.util.Timer
import java.util.TimerTask

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

const val TAG = "MainActivity"

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
            BaseItem2(Modifier
                .background(Color.Red)
                .align(Alignment.Start))
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
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.LightGray)
            , Arrangement.SpaceAround
            , verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier
                .size(100.dp)
                .background(Color.Red)
                .weight(1f, false))
            Box(Modifier
                .size(150.dp)
                .background(Color.Green)
                .weight(1f, false))
            Box(Modifier
                .size(100.dp)
                .background(Color.Blue)
                .weight(1f))
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
                Box(Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .background(Color.Green))
            }
        }

        repeat(10) {
            Box(Modifier
                .size(100.dp)
                .padding(10.dp)
                .background(Color.Green))
        }

        Row(Modifier.horizontalScroll(rememberScrollState())) {
            repeat(10) {
                Box(Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .background(Color.Green))
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

// No.7
@Composable
fun Greeting7(name: String, modifier: Modifier) {
    var countTest = 0
//    var count by remember { mutableStateOf(0) }   // ko luu gia tri khi xoay man hinh
    var count by rememberSaveable { mutableStateOf(0) }
    val history = remember { mutableStateListOf<Int>() }    // ko dung duoc statelist voi rememberSaveable
    Log.i(TAG, "Greeting7: count = $count")
    Column {
        Text("$count")
        Button(onClick = {
            count++
            countTest++
            history.add(count)
            Log.i(TAG, "onClick: $count | $countTest")
        }) {
            Text("+")
        }
        Text("History: ")
        for (value in history.toList()) {
            Text("$value")
        }
    }
}
// No.7 end

// No.8
@Composable
fun Greeting8(name: String, modifier: Modifier) {
    Column {
        TextField1()
        TextField2()
    }
}

@Composable
fun TextField1() {
    Log.i(TAG, "TextField1")
    var text by remember { mutableStateOf("") }

    TextField(value = text,
        onValueChange = {
            text = it
            Log.i(TAG, "onValueChange1: $text")
        },
        label = { Text("Label") },
        textStyle = TextStyle(color = Color.Blue),
        supportingText = { Icon(Icons.Default.Info, contentDescription = null)},
        placeholder = { Text("placeholder") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null)},
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Clear, contentDescription = null)
            }
        },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Color.Red,
            unfocusedContainerColor = Color.Green,
            focusedContainerColor = Color.Green,
            errorContainerColor = Color.Green,
            disabledContainerColor = Color.Green,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        prefix = { Text("Mr ")},    //>< suffix
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = { Log.i(TAG, "sent: $text")}
        )
    )
}

@Composable
fun TextField2() {
    Log.i(TAG, "TextField2")
    var text by remember { mutableStateOf("") }
    var isShowPassword by remember { mutableStateOf(false) }
    OutlinedTextField(value = text,
        onValueChange = {
            text = it
            Log.i(TAG, "onValueChange2: $text")
        },
        label = { Text("Label") },
        trailingIcon = {
            IconButton(onClick = { isShowPassword = !isShowPassword}) {
                Icon(Icons.Default.Check, contentDescription = null)
            }
        },
        visualTransformation = if (isShowPassword) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}
// No.8 end

// No.9
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Greeting9_1(name: String, modifier: Modifier) {
    var list = listOf("a", "b", "c", "d", "e", "f", "g", "h")
    Column {
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            //        horizontalAlignment = Alignment.CenterHorizontally,
            //        reverseLayout = true,
            //        userScrollEnabled = false
            modifier = Modifier.weight(1f)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .padding(10.dp)
                        .background(color = Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Header")
                }
            }

            items(list.size) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .padding(10.dp)
                        .background(color = Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = list[it])
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .padding(10.dp)
                        .background(color = Color.Blue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Footer")
                }
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            //        horizontalAlignment = Alignment.CenterHorizontally,
            //        reverseLayout = true,
            //        userScrollEnabled = false
            modifier = Modifier.weight(1f)
        ) {
            for (i in 0..2) {
                stickyHeader {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .padding(10.dp)
                            .background(color = Color.Red),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Header $i")
                    }
                }

                items(list.size) {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .padding(10.dp)
                            .background(color = Color.Green),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = list[it])
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting9_2(name: String, modifier: Modifier) {
    var list = listOf("a", "b", "c", "d", "e", "f", "g", "h")
    LazyVerticalGrid(
//        columns = GridCells.Fixed(2), // fix size 2
        columns = GridCells.FixedSize(100.dp),  // moi cot la 100dp
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(list) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .padding(10.dp)
                    .background(color = Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = it)
            }
        }
    }
}
// No.9 end

// No.10
data class TabItem(val text: String, val icon: ImageVector, val screen: @Composable () -> Unit)

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()
        , contentAlignment = Alignment.Center
    ) {
        Text(text = "Home Screen")
    }
}

@Composable
fun SettingScreen() {
    Box(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
        , contentAlignment = Alignment.Center
    ) {
        Text(text = "Setting Screen")
    }
}

@Composable
fun Greeting10(name: String, modifier: Modifier) {
    var tabIndex by remember { mutableStateOf(0) }
    var tabs = listOf(
        TabItem("Home", Icons.Default.Home, {
            HomeScreen()
        }),
        TabItem("Setting", Icons.Default.Settings, {
            SettingScreen()
        })
    )
    var pagerState = rememberPagerState(
        pageCount = { tabs.size }
    )
    var coroutineScope = rememberCoroutineScope()
    Log.i(TAG, "animateScrollToPage $tabIndex")
    Column {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, tabItem ->
                Tab(text = { Text(tabItem.text) },
                    icon = { Icon(tabItem.icon, contentDescription = null)},
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            Log.i(TAG, "animateScrollToPage $index")
                            tabIndex = index
                            pagerState.animateScrollToPage(index)
                            //pagerState.scrollToPage(index)
                        }
                    })
            }
        }
        //https://m3.material.io/components/navigation-bar/overview
        //https://m3.material.io/components/navigation-drawer/overview
        //https://m3.material.io/components/navigation-rail/overview

        HorizontalPager(state = pagerState) {
            tabs[it].screen
        }
//        VerticalPager
    }
}

// No.10 end

// No.11
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting11(name: String, modifier: Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    var isExpanded2 by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }
    Column {
        Row {
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { isExpanded = !isExpanded } ) {
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                DropdownMenu(expanded = isExpanded, onDismissRequest = { !isExpanded }) {
                    DropdownMenuItem(
                        text = { Text("Refresh") },
                        onClick = { isExpanded = false },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null
                            )
                        }
                    )
                    HorizontalDivider()
                    DropdownMenuItem(
                        text = { Text("Setting") },
                        onClick = { isExpanded = false},
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
            Spacer(Modifier.weight(1f))
        }

        ExposedDropdownMenuBox(
            expanded = isExpanded2,
            onExpandedChange = { isExpanded2 = !isExpanded2 }
        ) {
            TextField(
                value = text,
                onValueChange = {},
                modifier = Modifier.menuAnchor(),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded2)
                }
            )

            ExposedDropdownMenu(
                expanded = isExpanded2,
                onDismissRequest = { !isExpanded2 }
            ) {
                for (i in 0..2) {
                    DropdownMenuItem(
                        text = { Text(text = "Choose $i") },
                        onClick = {
                            isExpanded2 = false
                            text = "$i"
                        }
                    )
                }
            }
        }
        Box(Modifier
            .background(Color.Red)
            .fillMaxSize())
    }
}
// No.11 end

// No.12
@Composable
fun Greeting12(name: String, modifier: Modifier) {
    Column {
        Card (
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp),   // do bong
            colors = CardDefaults.cardColors(Color.Yellow),
            border = BorderStroke(2.dp, color = Color.Green)
        ) {
            Text(text = "Hello", Modifier.padding(8.dp))
            ListItem(
                leadingContent = { Icon(imageVector = Icons.Sharp.Delete, contentDescription = null) },
//                overlineContent = { Text("overlineContent") },
                headlineContent = { Text("headlineContent") },
                trailingContent = { Icon(imageVector = Icons.Rounded.Favorite, contentDescription = null) },
                supportingContent = { Text("supportingContent")},
                colors = ListItemDefaults.colors(Color.Cyan)
            )
        }

        Card (
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Hello", Modifier.padding(8.dp))
        }

        ElevatedCard (
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Hello", Modifier.padding(8.dp))
        }

        OutlinedCard (
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Hello", Modifier.padding(8.dp))
        }
    }
}
// No.12 end

// No.13
@Composable
fun Greeting13(name: String, modifier: Modifier) {
    Column(modifier.background(Color.LightGray)) {
        Image(
            painter = painterResource(R.drawable.screen),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
                .clip(shape = CircleShape)
                .border(BorderStroke(2.dp, Color.Yellow), CircleShape),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(R.drawable.setting),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .background(Color.Blue)
        )

        Image(
            painter = painterResource(R.drawable.home),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .background(Color.Green)
        )

        // Coil, Glide
    }
}
// No.13 end

// No.14
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting14(name: String, modifier: Modifier) {
    var openAlertDialog by remember { mutableStateOf(false) }
    var openBottomSheet by remember { mutableStateOf(false) }
    Column {
        ElevatedButton(onClick = { openAlertDialog = true }) {
            Text(text = "Open AlertDialog")
        }
        ElevatedButton(onClick = { openBottomSheet = true}) {
            Text(text = "Open BottomSheet")
        }
    }

    if (openAlertDialog) {
        AlertDialog(
            onDismissRequest = { openAlertDialog = false },
            title = { Text("Title") },
            text = { Text("Text") },
            confirmButton = {
                ElevatedButton(onClick = { openAlertDialog = false }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                ElevatedButton(onClick = { openAlertDialog = false }) {
                    Text("Dismiss")
                }
            }
        )
    }

    if (openBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { openBottomSheet = false },
            shape = BottomSheetDefaults.HiddenShape,
            scrimColor = Color.Cyan,
            containerColor = Color.Magenta
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "ModalBottomSheet")
                Row {
                    ElevatedButton(onClick = { openBottomSheet = false }, modifier = Modifier.weight(1f)) {
                        Text(text = "Done")
                    }
                    ElevatedButton(onClick = { openBottomSheet = false }, modifier = Modifier.weight(1f)) {
                        Text(text = "Close")
                    }
                }

            }
        }
    }
}
// No.14 end

// No.15
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting15(name: String, modifier: Modifier) {
    var datePickerState = rememberDatePickerState()
    var datePickerState2 = rememberDatePickerState()
    var showDatePickerDialog by remember { mutableStateOf(false) }

    var timePickerState = rememberTimePickerState()
    var timePickerState2 = rememberTimePickerState()
    var showTimePickerDialog by remember { mutableStateOf(false) }
    Column {
        // date picker
//        DatePicker(
//            state = datePickerState,
//            title = { Text("Title") },
//            headline = { Text("Headline") },
//            showModeToggle = true,
//            colors = DatePickerDefaults.colors(weekdayContentColor = Color.Red)
//        )
//        Text(
//            text = "Time picker = ${datePickerState.selectedDateMillis}",
//            modifier = modifier
//        )

        // time picker
        TimePicker(
            state = timePickerState,
            colors = TimePickerDefaults.colors(),
            layoutType = TimePickerLayoutType.Vertical
        )
        Text(
            text = "Time picker = ${timePickerState.hour} : ${timePickerState.minute}"
        )

        // date picker dialog
        Button(onClick = { showDatePickerDialog = true }) {
            Text(text = "Date Button")
        }
        if (showDatePickerDialog) {
            DatePickerDialog(
                onDismissRequest = {  },
                confirmButton = {
                    TextButton(onClick = { showDatePickerDialog = false }) {
                        Text("Confirm")
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState2
                )
            }
        }

        // time picker dialog
        Button(onClick = { showTimePickerDialog = true }) {
            Text(text = "Time Button")
        }
        if (showTimePickerDialog) {
            AlertDialog(
                onDismissRequest = { showTimePickerDialog = false }
            ) {
                Surface {
                    TimePicker(
                        state = timePickerState2
                    )
                }
            }
        }
    }
}
// No.15 end

// No.16
@Composable
fun Greeting16(name: String, modifier: Modifier) {
    var sliderPosition by remember { mutableStateOf(0f) }
    var sliderPosition2 by remember { mutableStateOf(0.2f..0.6f) }
    Column {
        CircularProgressIndicator()
        CircularProgressIndicator(
            progress = 0.8f,
            color = Color.Red,
            trackColor = Color.Green,
            strokeCap = StrokeCap.Round,
            strokeWidth = 10.dp
        )
        LinearProgressIndicator()
        Spacer(Modifier.height(20.dp))
        LinearProgressIndicator(
            progress = 0.8f,
            color = Color.Red,
            trackColor = Color.Green,
            modifier = Modifier.height(20.dp)
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            steps = 5,
            colors = SliderDefaults.colors(thumbColor = Color.Red)
        )
        Text(text = "$sliderPosition")
        RangeSlider(
            value = sliderPosition2,
            onValueChange = { sliderPosition2 = it },
            valueRange = 0.1f..4f
        )
    }
}
// No.16 end

// No.17
//https://developer.android.com/develop/ui/compose/side-effects
@Composable
fun Greeting17(name: String, modifier: Modifier) {
    var isVisible by remember { mutableStateOf(true) }
    Column {
        TextButton(onClick = { isVisible = !isVisible }) {
            Text(text = if (isVisible) "Hide" else "Show")
        }
    }
//    if (isVisible) {
//        Test()
//    }
    Test2(isVisible)
}

@Composable
fun Test() {
    Log.i(TAG, "start test")
    var count by remember { mutableStateOf(0) }

    LaunchedEffect(true) {
        delay(1000)
        Log.i(TAG, "LaunchedEffect true")
    }
    LaunchedEffect(Unit) {
        delay(1500)
        Log.i(TAG, "LaunchedEffect Unit")
    }
    LaunchedEffect(count) {
        delay(500)
        Log.i(TAG, "LaunchedEffect count = $count")
    }

    TextButton(onClick = { count++ }) {
        Text(text = "count = $count")
    }
    Log.i(TAG, "end test")
}

@Composable
fun Test2(isVisible: Boolean) {
    Log.i(TAG, "start test 2")
    var seconds by remember { mutableStateOf(0) }
    Text("Show $isVisible")
    DisposableEffect(key1 = isVisible) {
        Log.i(TAG, "DisposableEffect")
        val timer = Timer()
        timer.schedule(object: TimerTask() {
            override fun run() {
                seconds++
            }

        }, 0, 2000)

        onDispose {
            Log.i(TAG, "onDispose")
            timer.cancel()
        }
    }
    Text(text = "Seconds: $seconds")
    Log.i(TAG, "end test 2")
}
// No.17 end

// No.18
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Greeting18(name: String, modifier: Modifier) {
//    var count by remember { mutableStateOf(5) }
//    val refreshState = rememberPullToRefreshState()
//    if (refreshState.isRefreshing) {
//        LaunchedEffect(true) {
//            delay(1000)
//            count += 5
//            refreshState.endRefresh()
//        }
//    }
//    Box(Modifier.nestedScroll(refreshState.nestedScrollConnection)) {
//        LazyColumn(Modifier.fillMaxSize()) {
//            items(count) {
//                Text(text = "Item $it")
//            }
//            PullToRefreshContainer(
//                state = refreshState,
//                modifier = Modifier.align(Alignment.TopCenter)
//            )
//        }
//    }
//}
// No.18 end

// No.19
@Composable
fun Greeting19(name: String, modifier: Modifier) {
    Column {
//        rememberRipple(color = Color.Green)
        Box(
            modifier = Modifier.size(300.dp)
                .background(Color.Yellow)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = LocalIndication.current,
                    onClick = {}
                )
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            Log.i(TAG, "onDoubleTap $it")
                        },
                        onLongPress = {
                            Log.i(TAG, "onLongPress $it")
                        }
                    )
                }
        )
    }
}

// No.19 end

// No.20
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting20(name: String, modifier: Modifier) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Modal Drawer Sheet")
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text("Drawer Item") },
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.Favorite, contentDescription = null) }
                )
                ListItem(
                    headlineContent = { Text("List Item") },
                    trailingContent = {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("App Bar") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = null)
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Search, contentDescription = null)
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Info, contentDescription = null)
                        }
                    }
                )
            },
            bottomBar = {
                // BottomAppBar
                NavigationBar {
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = { Icon(Icons.Default.Settings, contentDescription = null) }
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Default.Add, contentDescription = null)
                }
            }
        ) {
            Column(Modifier.padding(it)) {

            }
        }
    }
}
// No.20 end

// https://m3.material.io/components

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeBasicTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting20("Android", modifier = Modifier)
        }
    }
}