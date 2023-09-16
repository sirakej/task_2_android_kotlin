package com.example.task_2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController


@Composable
fun TaskEdit(
    navController:NavHostController,

){
    var fullName by remember { mutableStateOf("")}
    var slackUsername by remember { mutableStateOf("")}
    var gitHubHandle by remember { mutableStateOf("")}
    var bioData by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        controllerEdit(
            text = fullName,
            "fullname",maxline = 1)
        {
                newText ->
            // Update the text when it changes
            fullName = newText
        }
        Spacer(modifier = Modifier.height(24.dp))
        controllerEdit(
            text = slackUsername,
            "slack username",maxline = 1)
        {
                newText ->
            // Update the text when it changes
            slackUsername = newText
        }
        Spacer(modifier = Modifier.height(24.dp))
        controllerEdit(
            text = gitHubHandle,
            "GitHub Handle",maxline = 1)
        {
                newText ->
            // Update the text when it changes
            gitHubHandle = newText
        }
        Spacer(modifier = Modifier.height(24.dp))
        controllerEdit(
            text = bioData,
            "bio-data",maxline = 6)
        {
                newText ->
            // Update the text when it changes
            bioData = newText
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            modifier = Modifier
                .height(48.dp)
                .width(100.dp),
            onClick = {
                navController.navigate(
                    route = Route.Details.pass(fullName,slackUsername,gitHubHandle,bioData)
                )
            }
        ) {
            Text(
                text = "Submit",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight(600)
            )
        }
    }
}

@Composable
fun controllerEdit(text:String, head:String, maxline:Int,onValueChange:(String)->Unit){
    var isFocused by remember { mutableStateOf(false) }
    Column(){
        Text(
            text = "$head:",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight(600)
        )
        Spacer(modifier = Modifier.height(10.dp))
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            //singleLine = true,
            maxLines = maxline,
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun check(){
    TaskEdit(navController = rememberNavController())
}