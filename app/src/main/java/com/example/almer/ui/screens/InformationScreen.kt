package com.example.almer.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.almer.R

@Composable
fun InformationScreen() {
    Scaffold(topBar = {
        AppBarInfo(
            title = "Information",
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
                Text(
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp),
                    text = "Almer Glasses #225",
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.padding(15.dp))

                Row() {
                    Text(
                        modifier = Modifier.padding(start = 15.dp, top = 15.dp),
                        text = "Serial Number:",
                        style = MaterialTheme.typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                       modifier = Modifier.padding(start = 5.dp, top = 13.dp),
                        text = "987-654-321",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
                Row() {
                    Text(
                        modifier = Modifier.padding(start = 15.dp, top = 15.dp),
                        text = "Version AlmerOS:",
                        style = MaterialTheme.typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp, top = 13.dp),
                        text = "1.0.1",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }
                Row() {
                    Text(
                        modifier = Modifier.padding(start = 15.dp, top = 15.dp),
                        text = "Company:",
                        style = MaterialTheme.typography.subtitle2,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp, top = 13.dp),
                        text = "jhondoe GmbH",
                        style = MaterialTheme.typography.subtitle1,
                    )
                }

                Spacer(modifier = Modifier.padding(15.dp))
                    Text(
                        modifier = Modifier.padding(start = 15.dp, top = 15.dp),
                        text = "Almer Technologies",
                        style = MaterialTheme.typography.subtitle2)

                Text(
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp),
                    text = "Marktgasse 46,3011 Bem",
                    style = MaterialTheme.typography.subtitle2)

                Text(
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp),
                    text = "contact.almer-technologies.com",
                    style = MaterialTheme.typography.subtitle2)

                Spacer(modifier = Modifier.padding(15.dp))
                Text(
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp),
                    text =
                            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
                    style = MaterialTheme.typography.subtitle2)



            }
        }
    }
}


@Composable
fun AppBarInfo(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
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

@Preview(showBackground = true)
@Composable
fun InfoDefaultPreview() {
    InformationScreen()
}