package com.example.composeui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeui.ui.theme.ComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

// 텍스트 뷰
@Composable
fun Greeting(name: String) {
    Text(text = name)
}

// 뷰를 그리는 곳(미리보기)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeUITheme {    // 자동으로 생성되는 테마
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
        ) {
            Column(
                modifier = Modifier.padding(all = 10.dp)
            ) {
                Text(text = "Hello Android!")
                Text(text = "Content!")
            }
        }
    }
}