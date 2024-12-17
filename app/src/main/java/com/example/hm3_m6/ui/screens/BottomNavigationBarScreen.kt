package com.example.hm3_m6.ui.screens

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.hm3_m6.ui.models.BottomNavItem

@Composable
fun BottomBar(navController : NavController){
    val icons = listOf(
        BottomNavItem.Choice,
        BottomNavItem.Detail,
        BottomNavItem.Profile,
        BottomNavItem.Favorite
    )
    
    BottomNavigation {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        icons.forEach{ item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.label)},
                label = { Text(item.label)},
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route){
                        navController.navigate(item.route){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }

            )
        }
    }
}