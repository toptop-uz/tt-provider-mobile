package com.toptop.provider.android.navigation

import androidx.navigation.NavHostController

fun NavHostController.navigateTo(destination: NavigationTree) {
    when (destination) {
        NavigationTree.NavigateUp -> navigateUp()
        else -> {
            navigate(destination.name)
        }
    }
}

fun NavHostController.navigateTo(
    destination: String,
    route: String? = null
) {
    navigate(route ?: destination)
}