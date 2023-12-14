package com.example.businesscard

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    val logo = painterResource(id = R.drawable.android_logo)
    val phoneIcon = R.drawable.baseline_phone_24
    val shareIcon = R.drawable.baseline_share_24
    val emailIcon = R.drawable.baseline_email_24
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFD2E8D4))) {
        Column(
            Modifier
                .fillMaxSize()
                .weight(0.7f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .background(color = Color(0xFF073042))
                    .size(100.dp, 100.dp),
                painter = logo,
                contentDescription = "My logo"
            )
            Text(
                text = stringResource(R.string.name_lastname_text),
                fontSize = 26.sp
            )
            Text(
                text = stringResource(R.string.occupation_text),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.primary)
            )
        }

        Column(
            Modifier
                .fillMaxSize()
                .weight(0.3f)) {
            AddRow(phoneIcon, stringResource(R.string.phone_number))
            AddRow(shareIcon, stringResource(R.string.share_text))
            AddRow(emailIcon, stringResource(R.string.email_text))
        }
    }

}

@Composable
fun AddRow(icon: Int, text: String){

    Row (horizontalArrangement = Arrangement.Start,
         modifier = Modifier
             .fillMaxWidth()
             .padding(5.dp)) {
        Spacer(Modifier.fillMaxWidth(0.2f))
        Icon(painter = painterResource(
            id = icon),
            contentDescription = null,
            tint = colorResource(id = R.color.primary)
        )
        Spacer(Modifier.width(15.dp))
        Text(
            text = text,
            color = colorResource(id = R.color.primary)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Screen()
    }
}