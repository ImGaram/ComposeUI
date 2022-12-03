package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeui.ui.theme.ComposeUITheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

class PracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    DefaultPreview2()
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = name)
}

@Composable
fun EditTextField() {
    val text = remember { mutableStateOf("") }
    TextField(value = text.value, onValueChange = { textValue -> text.value = textValue })
}

@Composable
fun ImageView() {
    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeUITheme {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {

            Column(modifier = Modifier.align(Alignment.Center)) {
                Image(painter = painterResource(id = R.drawable.practice_example_1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .align(Alignment.CenterHorizontally)
                        .offset(y = (-20).dp))

                val text = remember { mutableStateOf("") }
                val password = remember { mutableStateOf("") }
                // 비밀번호 보이게 하는 여부
                var passwordVisibility by remember { mutableStateOf(false) }
                val icon = if (passwordVisibility) {
                    painterResource(id = R.drawable.ic_baseline_visibility_24)
                } else painterResource(id = R.drawable.ic_baseline_visibility_off_24)
                // 이메일
                TextField(value = text.value, onValueChange = { textValue -> text.value = textValue },
                    label = {Text(text = "email")}, modifier = Modifier.offset(y = (-10).dp))
                // 비밀번호
                TextField(value = password.value, onValueChange = { textValue -> password.value = textValue },
                    label = {Text(text = "password")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(painter = icon, contentDescription = null)
                        }
                    },
                    visualTransformation = if (passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation()
                )
            }
        }
    }
}