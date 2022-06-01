package com.example.almer.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.almer.R
import com.example.almer.ui.theme.AlmerTheme

@Composable
fun SettingsScreen() {

    val mContext = LocalContext.current

    Scaffold(topBar = {
        AppBar(
            title = "Settings",
            icon = Icons.Default.ArrowBack,
            iconClickAction = {/* navController?.navigateUp()*/ }
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
              /*  Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Information about Almer Glasses",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(start= 65.dp))

                Spacer(modifier = Modifier.padding(20.dp))
                Text(text = "Give us feedback",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(end = 55.dp))

                Spacer(modifier = Modifier.padding(20.dp))
                Text(text = "Unpair Glasses with Smartphone",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(start = 55.dp))*/
                Spacer(modifier = Modifier.padding(10.dp))
                SettingsRow(image = R.drawable.info, text = "Information about Almer Glasses",
                modifier = Modifier.clickable { mToast(context = mContext ) })
                Spacer(modifier = Modifier.padding(20.dp))
                SettingsRow(image = R.drawable.feedback, text = "Give us feedback")
                Spacer(modifier = Modifier.padding(20.dp))
                SettingsRow(image = R.drawable.unpair, text = "Unpair Glasses with Smartphone")

            }
        }
    }
}
private fun mToast(context: Context){
    Toast.makeText(context, "I am Clicked", Toast.LENGTH_LONG).show()
}

@Composable
fun AppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = icon, "Content Description",
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .clickable { iconClickAction.invoke() }
            )
        },
        title = { Text(text = title) }
    )
}

@Composable
fun SettingsRow(
    image: Int,
    text: String,
    modifier: Modifier = Modifier
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
            Text(text = text, style = MaterialTheme.typography.subtitle1)


    }
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
  AlmerTheme {
      SettingsScreen()
  }
    }
