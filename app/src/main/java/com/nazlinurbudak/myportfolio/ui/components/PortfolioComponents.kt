package com.nazlinurbudak.myportfolio.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nazlinurbudak.myportfolio.data.model.Project

@Preview
@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier
) {
    val portfolioShowState = remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = modifier
                .width(200.dp)
                .height(400.dp)
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.Gray
            )
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                HorizontalDivider(
                    modifier = Modifier
                        .padding(20.dp)
                        .width(250.dp),
                    color = Color.Black,
                    thickness = 0.5.dp
                )
                PersonInfo()
                Button(onClick = {
                    portfolioShowState.value = !portfolioShowState.value
                }) {
                    Text(text = "Portfolio")
                }
                MyProjects(isShown = portfolioShowState.value)

            }

        }

    }

}

@Preview
@Composable
private fun ProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Black),
        shadowElevation = 10.dp
    ) {
        Icon(
            imageVector = Icons.Default.Android,
            modifier = modifier
                .clip(CircleShape)
                .background(Color.White)
                .padding(20.dp),
            contentDescription = "Portfolio Image",
        )
    }
}

@Preview
@Composable
private fun PersonInfo() {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Nazlı Budak",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@nbudak",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Preview
@Composable
fun MyProjects(modifier: Modifier = Modifier, isShown: Boolean = false) {
    if (isShown) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Surface(
                modifier = modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(width = 1.dp, color = Color.Black),
            ) {
                ProjectItem(
                    data = listOf(
                        Project(
                            projectName = "Project 1",
                            projectDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                        ),

                        Project(
                            projectName = "Project 2",
                            projectDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                        ),

                        Project(
                            projectName = "Project 3",
                            projectDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                        ),

                        Project(
                            projectName = "Project 4",
                            projectDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                        ),

                        Project(
                            projectName = "Project 5",
                            projectDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                        )
                    )
                )

            }
        }
    }
}

@Composable
fun ProjectItem(modifier: Modifier = Modifier, data: List<Project>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(
                    modifier = modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(10.dp)
                ) {
                    ProfileImage(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = modifier
                            .padding(10.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = item.projectName ?: "Project Name",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = item.projectDescription.toString(),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}