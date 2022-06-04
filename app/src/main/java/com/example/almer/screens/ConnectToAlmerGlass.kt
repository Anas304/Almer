package com.example.almer.screens

import android.content.Intent
import android.net.Uri
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.almer.R
import com.example.almer.navigation.Screens
import com.example.almer.ui.theme.AlmerTheme

@Composable
fun ConnectToAlmerGlass(navController: NavController) {

    //going to the website
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://almer-technologies.com/contact-us/")) }


    Scaffold(topBar = {
        AppBarConnectToAG(
            title = "Connect to Almer Glasses",
            icon = R.drawable.ic_baseline_arrow_back,
            iconClickAction = { navController.navigateUp() }
        )
    }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                ) {

                    Image(
                        painter = rememberImagePainter(data = R.drawable.arrowdown),
                        modifier = Modifier
                            .padding(top = 100.dp, start = 40.dp)
                            .size(25.dp),
                        contentDescription = "image"
                    )
                    Image(
                        painter = rememberImagePainter(data = R.drawable.glassesfront),
                        modifier = Modifier
                            .size(400.dp),
                        contentDescription = "image"
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                ) {
                    Row() {
                        Text(text = "1.", fontSize = 15.sp,
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Text(text = "Press the big button on the glasses for \r \n 1-2 seconds.", fontSize = 15.sp,
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Row() {
                        Text(text = "2.", fontSize = 15.sp,
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Text(text = "Press the below to pair the glasses with \r \n your smartphone.", fontSize = 15.sp,
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                    }
                }

                Column(modifier = Modifier.padding(start = 100.dp, top = 20.dp)) {
                    OutlinedButton(
                        onClick = { navController.navigate(Screens.MainScreen.route)},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.textButtonColors(backgroundColor = Color(0xFF7F7F7F)),
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.pin),
                            modifier = Modifier.size(15.dp),
                            contentDescription = "content description",
                            tint = Color(0xFFEEEEEE)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = "Connect Glasses", color = Color.White)
                    }

                    OutlinedButton(
                        onClick = { context.startActivity(intent) },
                        colors = ButtonDefaults.textButtonColors(backgroundColor = Color.White),
                        modifier = Modifier
                            .wrapContentSize(),
                        border= BorderStroke(1.dp, Color.White)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.almersmall),
                            modifier = Modifier.size(15.dp),
                            contentDescription = "content description",
                            tint = Color(0xFF7F7F7F)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = "Get support from us", color = Color(0xFF7F7F7F))
                    }

                }
            }


        }
    }


}

@Composable
fun AppBarConnectToAG(title: String, icon: Int, iconClickAction: () -> Unit) {
    TopAppBar(
        backgroundColor = Color(0xFF7F7F7F),
        navigationIcon = {
            Image(
                painter = painterResource(icon),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.White),
              modifier =  Modifier.clickable { iconClickAction.invoke() }
            )
        },
        title = { Text(text = title, color = Color.White) }
    )

}

/*

@Preview(showBackground = true)
@Composable
fun ConnectPreview() {
    AlmerTheme {
        ConnectToAlmerGlass()
    }
}*/
