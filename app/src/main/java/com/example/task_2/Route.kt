package com.example.task_2

//DETAILS
const val DETAILS_FULLNAME= "fullname"
const val DETAILS_SLACK_USERNAME = "slack_username"
const val DETAILS_GITHUB= "github_handle"
const val DETAILS_BIODATA = "bio_data"
//TASKEDIT
//const val TASK_EDIT_FULLNAME = "edit_name"
//const val TASK_EDIT_SLACK_USERNAME= "edit_slack"
//const val TASK_EDIT_GITHUB= "edit_github_handle"
//const val TASK_EDIT_BIODATA= "edit_bio_data"

sealed class Route(val route:String){
    object Details:Route(
        route = "details_screen/{$DETAILS_FULLNAME}/{$DETAILS_SLACK_USERNAME}/{$DETAILS_GITHUB}/{$DETAILS_BIODATA}"
    ){
        fun pass(
            fullname:String,
            slack_username:String,
            github_handle:String,
            bio_data:String
        ): String{
            return "details_screen/$fullname/$slack_username/$github_handle/$bio_data"
        }
    }
    object TaskEdit:Route(
        route = "edit_screen"
    ){
//        fun edit_pass(
//            edit_name:String,
//            edit_slack:String,
//            edit_github_handle:String,
//            edit_bio_data:String
//        ): String{
//            return "details_screen"
//        }
    }
}
