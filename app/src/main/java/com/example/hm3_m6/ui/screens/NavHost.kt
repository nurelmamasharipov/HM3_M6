package com.example.hm3_m6.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavHost () {
    val navController = rememberNavController()

    Scaffold (
        bottomBar = { BottomBar(navController = navController)}
    ) { paddingValues ->
        NavHost(navController = navController,
            startDestination = "choice",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("choice") { ChoiceScreen(navController)}
            composable("favorite") { FavoriteScreen() }
            composable(
                route = "detail/{bookId}",
                arguments = listOf(navArgument("bookId") { type = NavType.IntType })
            ) { backStackEntry ->
                val bookId = backStackEntry.arguments?.getInt("bookId")
                DetailScreen(bookId)
            }
            composable("profile") { ProfileScreen() }
        }
    }
}