package com.peter.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.peter.compose.ui.LayoutsCodelabTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsCodelabTheme {
                LayoutCodelab()
            }
        }
    }
}

@Composable
fun LayoutCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "LayoutCodelab")
            },
            actions = {
                IconButton(onClick = { /*doSomething()*/ }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            })
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding).padding(8.dp))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layout codelab")
    }
}

@Preview
@Composable
fun LayoutCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutCodelab()
    }
}
