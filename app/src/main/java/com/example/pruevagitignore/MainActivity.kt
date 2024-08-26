package com.example.pruevagitignore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruevagitignore.ui.theme.PruevaGitignoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruevaGitignoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    GeetingTexField("nilton")
                    SnackbarEjemplo()
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
// Esto será el priemro cambio de prueba
@Composable
fun GeetingTexField(
    name: String, modifier: Modifier = Modifier){
    var mutableValue by remember {mutableStateOf("")}
    Column(
        modifier = modifier
            .padding(30.dp)
    ){
        TextField(value = mutableValue, onValueChange = {mutableValue = it})
    }
}




@Composable
fun SnackbarEjemplo() {
    var showSnackbar by remember {
        mutableStateOf(
            false
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showSnackbar = true }) {
            Text("Mostrar Snackbar")
        }

        if (showSnackbar) {
            Snackbar(
                action = {
                    TextButton(onClick = { showSnackbar = false }) {
                        Text("OK")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("¡Hola desde el Snackbar!")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruevaGitignoreTheme {
        Greeting("Android")
    }
}