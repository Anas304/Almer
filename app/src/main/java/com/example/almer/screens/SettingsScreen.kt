package com.example.almer.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.almer.R
import com.example.almer.navigation.Screens
import com.example.almer.ui.theme.AlmerTheme

@Composable
fun SettingsScreen(navController: NavController) {



    Scaffold(topBar = {
        AppBar(
            title = "Settings",
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
                Spacer(modifier = Modifier.padding(10.dp))
                SettingsRow(image = R.drawable.info, text = "Information about Almer Glasses",
                    navController = navController)
                Spacer(modifier = Modifier.padding(20.dp))
                FeedbackRow(image = R.drawable.feedback, text = "Give us feedback",
                navController = navController)
                Spacer(modifier = Modifier.padding(20.dp))
                UnpairRow(image = R.drawable.unpair, text = "Unpair Glasses with Smartphone",
                navController = navController)

            }
        }
    }
}

@Composable
fun AppBar(title: String, icon: Int, iconClickAction: () -> Unit) {
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
        title = { Text(text = title,color = Color.White) }
    )
}

@Composable
fun SettingsRow(
    image: Int,
    text: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = rememberImagePainter(data = image),
                modifier = Modifier.size(25.dp),
                contentDescription = "content description"
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = text, style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.clickable {navController.navigate(Screens.InformationScreen.route) })


    }
}
@Composable
fun FeedbackRow(image: Int, text: String, modifier: Modifier = Modifier, navController: NavController
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://almer-technologies.com/contact-us/")) }

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = rememberImagePainter(data = image),
            modifier = Modifier.size(25.dp),
            contentDescription = "content description"
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = text, style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.clickable {context.startActivity(intent)})


    }
}
@Composable
fun UnpairRow(image: Int, text: String, modifier: Modifier = Modifier, navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = rememberImagePainter(data = image),
            modifier = Modifier.size(25.dp),
            contentDescription = "content description"
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = text, style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.clickable {navController.navigate(Screens.AlmerGlassList.route)})


    }
}


/*@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
  AlmerTheme {
      SettingsScreen()
  }
    }*/
