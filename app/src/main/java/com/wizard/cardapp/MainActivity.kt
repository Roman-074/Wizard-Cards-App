package com.wizard.cardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wizard.cardapp.ui.theme.WizardCardAppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WizardCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SimpleFilledTextFieldSample()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@ExperimentalMaterial3Api
@Composable
fun SimpleFilledTextFieldSample() {
    var selected by remember { mutableStateOf(false) }
    val color = if (selected) Color.Blue else Color.Yellow
    Row {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = color,
                contentColor = Color.Black
            ),
            onClick = {
                selected = !selected
            }) {
            Text(text = "Hello Android")
        }
    }
}
