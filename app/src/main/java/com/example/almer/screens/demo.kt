package com.example.almer.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun TwoAreas() {

    Box(contentAlignment = Alignment.Center) {
        Column {
            Row(modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()
                .background(color = Color.Red)) {
            }

            Row(modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()
                .background(color = Color.Blue)) {
            }
        }

        Box(modifier = Modifier
            .background(color = Color.Black)
            .height(100.dp)
            .width(100.dp))
    }
    LaunchedEffect(Unit){
        delay(8000L)
    }











}
@Preview(showBackground = true)
@Composable
fun TwoAreasPrev() {
    TwoAreas()
}