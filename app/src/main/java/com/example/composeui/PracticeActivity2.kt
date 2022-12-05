package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.composeui.data.Practice2Data
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

@Composable
fun RecyclerView() {    // recycler view
    LazyColumn {
        itemsIndexed(listOf(1,2,3,4,5,6,7,8,9,10)) { index, item ->
            ScrollItem(num = item)
        }
    }
}

@Composable
fun ExampleItem(item: Practice2Data) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        // 배경 박스
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(start = 15.dp, end = 15.dp)
        ) {
        }

        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            Column(modifier = Modifier.offset(x = 10.dp)) {
                Text(text = "이름:"+item.name, modifier = Modifier.offset(y = (-5).dp))
                Text(text = "나이:"+item.age.toString(), modifier = Modifier.offset(y = 5.dp))
            }
        }

        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.offset(x = (-5).dp)
        ) {
            Text(text = "phone:"+item.phoneNum)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    val item = mutableListOf<Practice2Data>()
    item.add(0, Practice2Data("name1", 16, "010-1234-5678"))
    item.add(1, Practice2Data("name2", 18, "010-2345-6789"))
    item.add(2, Practice2Data("name3", 20, "010-3456-7890"))
    item.add(3, Practice2Data("name4", 18, "010-1111-2222"))
    item.add(4, Practice2Data("name5", 20, "010-2222-3333"))
    item.add(5, Practice2Data("name6", 24, "010-3333-4444"))
    item.add(6, Practice2Data("name7", 15, "010-4444-5555"))

    ComposeUITheme {
        LazyColumn {
            itemsIndexed(item) { index, data ->  
                ExampleItem(item = data)
            }
        }
    }
}