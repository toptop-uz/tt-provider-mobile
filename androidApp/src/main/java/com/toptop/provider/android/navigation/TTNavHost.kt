package com.toptop.provider.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun TTNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        selectLanguageGraph(navController)
        authGraph(navController)
    }
}