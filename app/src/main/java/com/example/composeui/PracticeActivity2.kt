package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeui.ui.theme.ComposeUITheme

class PracticeActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    DefaultPreview3()
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ScrollItem(num: Int) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .border(width = 5.dp, color = Color.Blue, shape = CircleShape)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "text $num", color = Color.Blue)
        }
    }
}

@Composable
fun ScrollableView() {  // scroll view
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(scroll)
    ) {
        for (i in 0..10) {
            ScrollItem(num = i)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeUITheme {
        // recycler view
        LazyColumn {
            itemsIndexed(listOf(1,2,3,4,5,6,7,8,9,10)) { index, item ->  
                ScrollItem(num = item)
            }
        }
    }
}