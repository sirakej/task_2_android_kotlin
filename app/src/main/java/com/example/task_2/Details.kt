package com.example.task_2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun DetailsScreen(
    navController:NavHostController,
    fullname:String,
    slack:String,
    githubHandle:String,
    bioData:String
){
    val first = "Oluwafemi Akeju"
    val second = "@Sirakej"
    val third = "https://github.com/sirakej"
    val fourth = "My name is already stated in this app, i am currently interning as a mobile developer and i pray i am able to complete all task given, get to the finalist and understand the task well."

    Box(
        modifier = Modifier
            .background(color = Color.Black)
            //.padding(top = 5.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
        ){
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "TASK_2_CV_INFORMATION",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
        }
        Column {
            Spacer(modifier = Modifier.height(50.dp))
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(10.dp, 10.dp, 0.dp,0.dp)
            ){
                Column(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 16.dp, end = 16.dp),
                ) {
                    content(
                        head = "Fullname",
                        details = if(fullname.contains("null")||fullname.isEmpty())
                        {
                            first
                        }else
                        {
                            fullname
                        })
                    Spacer(modifier = Modifier.height(24.dp))
                    content(
                        head = "Slack username",
                        details = if(slack.contains("null")||slack.isEmpty())
                        {
                            second
                        }else
                        {
                            slack
                        })
                    Spacer(modifier = Modifier.height(24.dp))
                    content(
                        head = "GitHub handle",
                        details = if(githubHandle.contains("null")||githubHandle.isEmpty())
                        {
                            third
                        }else
                        {
                            githubHandle
                        })
                    Spacer(modifier = Modifier.height(24.dp))
                    content(
                        head = "Personal Bio",
                        details = if(bioData.contains("null")||bioData.isEmpty())
                        {
                            fourth
                        }else
                        {
                            bioData
                        }
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                }
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .padding(bottom = 16.dp, end = 16.dp)
                .align(alignment = Alignment.BottomEnd),
            containerColor = Color.Black,
            onClick = {
                navController.navigate(
                    route = Route.TaskEdit.route
                )
                      },
        ) {
            Icon(Icons.Filled.Edit, "Floating action button.", tint = Color.White)
        }
    }
}



@Composable
fun content(head:String, details:String){
    Column{
        Text(
            text = "$head:",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight(600)
        )
        Text(
            text = "$details",
            color = Color.Black,
            fontSize = 18.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview(){
    DetailsScreen(navController = rememberNavController(),"","","","")
}
