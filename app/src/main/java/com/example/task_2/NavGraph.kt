package com.example.task_2

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Route.Details.route
    ) {
        composable(
            route = Route.Details.route,
            arguments = listOf(
                navArgument(DETAILS_FULLNAME){
                    type = NavType.StringType
                },
                navArgument(DETAILS_SLACK_USERNAME){
                    type = NavType.StringType
                },
                navArgument(DETAILS_GITHUB){
                    type = NavType.StringType
                },
                navArgument(DETAILS_BIODATA){
                    type = NavType.StringType
                },
            )
        ){
            DetailsScreen(
                navController = navController,
                it.arguments?.getString(DETAILS_FULLNAME).toString(),
                it.arguments?.getString(DETAILS_SLACK_USERNAME).toString(),
                it.arguments?.getString(DETAILS_GITHUB).toString(),
                it.arguments?.getString(DETAILS_BIODATA).toString(),
            )
        }
        composable(
            route = Route.TaskEdit.route,
//            arguments = listOf(
//                navArgument(TASK_EDIT_FULLNAME){
//                    type = NavType.StringType
//                },
//                navArgument(TASK_EDIT_SLACK_USERNAME){
//                    type = NavType.StringType
//                },
//                navArgument(TASK_EDIT_GITHUB){
//                    type = NavType.StringType
//                },
//                navArgument(TASK_EDIT_BIODATA){
//                    type = NavType.StringType
//                },
//            )
        ){
            TaskEdit(
                navController = navController,
            )
        }
    }
}