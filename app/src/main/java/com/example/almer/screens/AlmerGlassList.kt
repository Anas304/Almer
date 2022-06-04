package com.example.almer.screens

import android.widget.Space
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.almer.R
import com.example.almer.model.AlmerGlass
import com.example.almer.model.almerGlassList
import com.example.almer.viewmodel.AlmerViewModel

@Composable
fun AlmerGlassList(navController: NavController) {

    val viewmodel: AlmerViewModel = viewModel()
    var loading = viewmodel.progressBarloading.value
    val almerGlasses: List<AlmerGlass> = almerGlassList

    /** Nav to  Settings Screen*/
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column {

            Row(
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxWidth()
                    .background(color = Color(0xFF7F7F7F))
            ) {
                Image(
                    painter = rememberImagePainter(data = R.drawable.almerlogo),
                    contentDescription = "content Description",
                    modifier = Modifier
                        .padding(start = 130.dp, top = 5.dp)
                        .size(130.dp)
                        .fillMaxSize(),
                    //contentScale = ContentScale.Inside,
                )

            }
            Row(
                modifier = Modifier
                    .weight(2.7f)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {


            }
        }
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = R.drawable.glasses
                ),
                modifier = Modifier
                    .padding(bottom = 315.dp)
                    .size(370.dp),
                contentDescription = "Content Description"
            )
        }//Image Box
        Column(
            modifier = Modifier.padding(top = 10.dp, start = 20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Connect your Almer Glasses",
                fontSize = 20.sp,
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))
        Column(
            // modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "To receive calls and adjust other settings  on \r \n your Almer Glasses, " +
                        "you need to turn them  on \r \n and connect them to your smartphone \r     \n",
                fontSize = 15.sp,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(start = 20.dp, top = 120.dp, end = 5.dp),

                //fontWeight = FontWeight.Normal
            )
        }

        Column(modifier = Modifier.padding(top = 400.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            //TODO LAZYCOLUMN
            LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp)) {
                items(almerGlasses) { almerGlass ->
                    AlmerCard(almerGlass = almerGlass, onClick = { })
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            CircularProgressAnimated(isDisplayed = loading)
        }
        
    }//MainBox
}

@Composable
fun AlmerCard(almerGlass: AlmerGlass, onClick: () -> Unit) {

    Row(
        modifier = Modifier
            .padding(start = 10.dp)
            .wrapContentSize(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AlmerIcon(icon = R.drawable.itemlabel)
        Spacer(modifier = Modifier.padding(20.dp))
        AlmerContent(
            glassName = almerGlass.name,
            status = almerGlass.status,
            alignment = Alignment.Start
        )
    }


}

@Composable
fun AlmerIcon(icon: Int) {
    Image(
        modifier = Modifier.size(50.dp),
        painter = rememberImagePainter(data = icon,
            builder = {
                /** Empty for now*/
                // transformations(CircleCropTransformation())
            }),
        contentDescription = "Content Description",
    )
}

@Composable
fun AlmerContent(glassName: String, status: String, alignment: Alignment.Horizontal) {
    
        Column(
            modifier = Modifier.padding(end = 150.dp),
            horizontalAlignment = alignment,
        ) {
            Text(text = glassName, style = MaterialTheme.typography.subtitle2)

            //CompositionLocalProvider is used for making the Text Transparent
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = status,
                    style = MaterialTheme.typography.body2
                )

            }
        }
    

}


@Composable
private fun CircularProgressAnimated(isDisplayed: Boolean) {
    val progressValue = 0.75f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue, animationSpec = infiniteRepeatable(animation = tween(900))
    )

    CircularProgressIndicator(
        progress = progressAnimationValue,
        modifier = Modifier.size(25.dp),
        color = Color(0xFF7F7F7F)
    )
}

/*
@Preview(showBackground = true)
@Composable
fun AlmerGlassListPreview() {
    AlmerGlassList()
}*/
