package com.example.almer.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.almer.R


@Composable
fun MainContainer() {
    Box(contentAlignment = Alignment.Center) {
        Column {
            Row(modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()
                .background(color = Color.DarkGray)) {
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

            Row(modifier = Modifier
                .weight(1.8f)
                .fillMaxWidth()
                .background(color = Color.White)) {
            }
        }

        //TODO our Almer Glasses card
        Box(modifier = Modifier
            .background(color = Color.Black)
            .height(100.dp)
            .width(100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  MainContainer()
}