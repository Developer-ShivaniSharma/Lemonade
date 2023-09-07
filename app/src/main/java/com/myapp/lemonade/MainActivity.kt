package com.myapp.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapp.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(0) }
    var currentStep by remember { mutableStateOf(1) }

    when (currentStep) {
        1 -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val borderColor = Color(195, 236, 210)
                Image(
                    painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = stringResource(R.string.lemon_content_description),
                    modifier = Modifier
                        .wrapContentSize()
                        .background(borderColor, AbsoluteRoundedCornerShape(4.dp))
                        .border(
                            width = 2.dp,
                            color = borderColor,
                            shape = AbsoluteRoundedCornerShape(4.dp)
                        ).padding(17.dp)
                        .clickable {
                            counter = (2..4).random()
                            currentStep = 2
                        }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.lemon_tree),
                    fontSize = 18.sp
                )
            }

        }

        2 -> {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val borderColor = Color(195, 236, 210)
                Image(
                    painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = stringResource(R.string.lemon_content_description),
                    modifier = Modifier
                        .wrapContentSize()
                        .background(borderColor, AbsoluteRoundedCornerShape(4.dp))
                        .border(
                            width = 2.dp,
                            color = borderColor,
                            shape = AbsoluteRoundedCornerShape(4.dp)
                        ).padding(17.dp)
                        .clickable {
                            counter--
                            if (counter == 0) {
                                currentStep = 3
                            }
                        }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.lemon)
                )

            }
        }

        3 -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val borderColor = Color(195, 236, 210)
                Image(
                    painter = painterResource(R.drawable.lemon_drink),
                    contentDescription = stringResource(R.string.lemon_content_description),
                    modifier = Modifier
                        .wrapContentSize()
                        .background(borderColor, AbsoluteRoundedCornerShape(4.dp))
                        .border(
                            width = 2.dp,
                            color = borderColor,
                            shape = AbsoluteRoundedCornerShape(4.dp)
                        ).padding(17.dp)
                        .clickable { currentStep = 4 }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.glass_of_lemonade)
                )

            }

        }

        4 -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val borderColor = Color(195, 236, 210)

                Image(
                    painter = painterResource(R.drawable.lemon_restart),
                    contentDescription = stringResource(R.string.lemon_content_description),
                    modifier = Modifier
                        .wrapContentSize().background(borderColor, AbsoluteRoundedCornerShape(4.dp))
                        .border(
                            width = 2.dp,
                            color = borderColor,
                            shape = AbsoluteRoundedCornerShape(4.dp)
                        ).padding(17.dp)
                        .clickable { currentStep = 1 }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(R.string.empty_glass),
                    fontSize = 18.sp
                )

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade()
    }
}
