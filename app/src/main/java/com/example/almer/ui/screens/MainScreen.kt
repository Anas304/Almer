package com.example.almer.ui.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.almer.R


@Composable
fun MainContainer() {
    Box(contentAlignment = Alignment.Center) {
        Column {
            Row(
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxWidth()
                    .background(color = Color.DarkGray)
            ) {
                Image(
                    painter = rememberImagePainter(data = R.drawable.almerlogo),
                    contentDescription = "content Description",
                    modifier = Modifier
                        .padding(start = 20.dp, top = 30.dp)
                        .size(140.dp)
                        .fillMaxSize(),
                    //contentScale = ContentScale.Inside,
                )

                Image(
                    painter = rememberImagePainter(data = R.drawable.ic_baseline_settings_24),
                    contentDescription = "content Description",
                    modifier = Modifier
                        .padding(start = 180.dp, top = 85.dp)
                        .size(30.dp)
                        .fillMaxSize(),
                    //contentScale = ContentScale.Inside,
                )

            }

            Row(
                modifier = Modifier
                    .weight(1.8f)
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
            ) {
            }
        }

        //TODO our Almer Glasses card
/*        Box(modifier = Modifier
            .background(color = Color.Black)
            .height(100.dp)
            .width(100.dp))*/
        Card(
            Modifier
                .padding(20.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 20.dp
        ) {
            Column(
                Modifier
                    .padding(30.dp)
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Almer Glasses #225",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.body1,
                    //fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Row(
                    Modifier
                        .fillMaxWidth()
                ) {

                    Image(
                        painter = rememberImagePainter(data = R.drawable.dot),
                        contentDescription = "Device battery status icon",
                        modifier = Modifier
                            .padding(top = 7.dp, start = 105.dp)
                            .size(8.dp)
                    )

                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "connected",
                        style = MaterialTheme.typography.subtitle2
                    )
                    Spacer(modifier = Modifier.padding(3.dp))

                    Image(
                        painter = rememberImagePainter(data = R.drawable.ic_baseline_battery_5_bar_24),
                        contentDescription = "Device battery status icon",
                        modifier = Modifier
                            .padding(top = 1.dp, end = 5.dp)
                            .size(20.dp)
                    )
                    Text(
                        //modifier = Modifier.padding(start = 1.dp),
                        text = "84%",
                        style = MaterialTheme.typography.subtitle2
                    )
                }
                Image(painter = rememberImagePainter(data = R.drawable.render_3_4right_1),
                    contentDescription = "Content Image",
                    modifier = Modifier.size(300.dp)
                    )
                Row {
                    UserControlls(numberText = "Wifi", image = R.drawable.ic_baseline_wifi_24 )
                }

            }

        }
    }
}

@Composable
fun UserControlls(
    numberText: String,
    image : Int,
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = numberText, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = rememberImagePainter(data = image),
                modifier = Modifier.size(30.dp),
                contentDescription = "content description" )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContainer()
}