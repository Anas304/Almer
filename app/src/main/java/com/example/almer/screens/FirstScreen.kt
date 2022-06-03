package com.example.almer.screens

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.almer.R
import com.example.almer.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun FirstScreen(navController: NavController) {
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

        Column(modifier = Modifier.padding(top = 300.dp)) {
            CircularProgressAnimated()
            Box(
                modifier = Modifier
                    .wrapContentSize(),
            contentAlignment = Alignment.BottomCenter){
                SimpleAlertDialog(navController = navController)
            }
        }


    }//MainBox

}

//TODO CustomDialoguePosition to position AlertDialogue just a little below Glasses Image
/*

enum class CustomDialogPosition {
    BOTTOM, TOP,CENTRE
}

fun Modifier.customDialogModifier(pos: CustomDialogPosition) = layout { measurable, constraints ->

    val placeable = measurable.measure(constraints);
    layout(constraints.maxWidth, constraints.maxHeight){
        when(pos) {
            CustomDialogPosition.BOTTOM -> {
                placeable.place(0, constraints.maxHeight - placeable.height, 10f)
            }
            CustomDialogPosition.TOP -> {
                placeable.place(0,0,10f)
            }
            CustomDialogPosition.CENTRE -> {
                placeable.place(0,constraints.minWidth + placeable.width,10f)
            }
        }
    }
}
*/




@Composable
fun SimpleAlertDialog(navController: NavController) {
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = {})
            {
                Text(
                    text = "Retry", fontSize = 14.sp, color = Color.Black,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(bottom = 30.dp)
                )
            }
        },
        modifier = Modifier
            //.customDialogModifier(CustomDialogPosition.CENTRE)
            .size(290.dp)
            .wrapContentSize()
            .padding(bottom = 120.dp,),
        dismissButton = {
            TextButton(onClick = { navController.navigate(Screens.ConnectToAlmerScreen.route) })
            {
                Text(
                    text = "How to turn on my Glasses", fontSize = 14.sp, color = Color.Black,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                )
            }
        },
        shape = RoundedCornerShape(24.dp),
        title = {
            Text(
                text = "Almer Glasses not found",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(start = 20.dp, top = 15.dp),
                fontSize = 18.sp
            )
        },
        text = {
            Text(
                text = "please make sure your glasses are turned on and next to your smartphone",
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    )
}


//Determinate (based on input)
@Composable
private fun CircularProgressAnimated() {
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
fun FirstScreenPreview() {
    FirstScreen()
}
*/
