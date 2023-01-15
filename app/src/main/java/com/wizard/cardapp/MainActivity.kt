package com.wizard.cardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wizard.cardapp.ui.theme.WizardCardAppTheme
import com.wizard.cardapp.ui.theme.montserrat

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

                    ScreenDetails()
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
fun ScreenDetails() {

    val localDensity = LocalDensity.current

    var columnIconBackHeightDp by remember {
        mutableStateOf(0.dp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, top = 15.dp)
    ) {

        // Hat
        Row(
            modifier = Modifier.onGloballyPositioned { coordinates ->
               columnIconBackHeightDp = with(localDensity) { coordinates.size.height.toDp() }
            }
        ) {

            // Icon back
            Column(
                modifier = Modifier.width(24.dp).height(columnIconBackHeightDp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_baseline_arrow_back_ios_24
                    ),
                    contentDescription = "Back",
                )
            }

            // Title
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Детали карточки",
                    fontFamily = montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Color.Black
                )
            }
        }

        // Card image
        Row(modifier = Modifier.padding(top = 85.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card_sample),
                    contentDescription = "Card",
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .shadow(5.dp)
                        .padding(28.dp)
                        .width(300.dp)
                        .height(280.dp),
                )
            }
        }

        // Character name
        Row(modifier = Modifier.padding(top = 437.dp, start = 16.dp)) {
            Text(
                text = "Имя фамилия",
                fontFamily = montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        // Character description
        Row(modifier = Modifier.padding(top = 460.dp, start = 16.dp)) {
            Text(
                text = "Описание жизни волшебника",
                fontFamily = montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
