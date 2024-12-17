package com.example.hm3_m6.ui.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem (val route: String, val icon: ImageVector, val label:String){
    object Choice : BottomNavItem("choice", Icons.Default.Menu, "Choice")
    object Detail : BottomNavItem("detail", Icons.Default.Info, "Detail")
    object Favorite : BottomNavItem("favorite", Icons.Default.Favorite, "Favorite")
    object Profile : BottomNavItem("profile", Icons.Default.AccountCircle, "Profile")
}