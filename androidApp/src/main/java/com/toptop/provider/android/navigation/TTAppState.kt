package com.toptop.provider.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberTTAppState(
    navController: NavHostController = rememberNavController()
): TTAppState {
    return remember(navController) { TTAppState(navController) }
}

@Stable
class TTAppState(val navController: NavHostController) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

//    val topLevelDestinations: List<TopLevelDestination> = listOf(
//        TopLevelDestination(
//            route = HomeDestination.route,
//            destination = HomeDestination.destination,
//            selectedIcon = MuslimIcons.Home,
//            unselectedIcon = MuslimIcons.Home,
//            iconTextId = R.string.menu_home
//        ),
//        TopLevelDestination(
//            route = QuranDestination.route,
//            destination = QuranDestination.destination,
//            selectedIcon = MuslimIcons.Book,
//            unselectedIcon = MuslimIcons.Book,
//            iconTextId = R.string.quran
//        ),
//        TopLevelDestination(
//            route = QiblaDestination.route,
//            destination = QiblaDestination.destination,
//            selectedIcon = MuslimIcons.Explore,
//            unselectedIcon = MuslimIcons.Explore,
//            iconTextId = R.string.menu_qibla
//        ),
//        TopLevelDestination(
//            route = MoreDestination.route,
//            destination = MoreDestination.destination,
//            selectedIcon = MuslimIcons.MoreHoriz,
//            unselectedIcon = MuslimIcons.MoreHoriz,
//            iconTextId = R.string.menu_more
//        )
//    )

//    fun navigate(
//        destination: MuslimNavigationDestination,
//        route: String? = null
//    ) {
//        when (destination) {
//            is TopLevelDestination -> {
//                navController.navigate(route ?: destination.route) {
//                    // Pop up to the start destination of the graph to
//                    // avoid building up a large stack of destinations
//                    // on the back stack as users select items
//                    popUpTo(navController.graph.findStartDestination().id) {
//                        saveState = true
//                    }
//                    // Avoid multiple copies of the same destination when
//                    // reselecting the same item
//                    launchSingleTop = true
//                    // Restore state when reselecting a previously selected item
//                    restoreState = true
//                }
//            }
//            is HomeDestination -> {
//                navController.popBackStack(LocateMeDestination.route, true)
//                navController.navigate(destination.route)
//            }
//            is SettingsDestination -> navController.navigate(destination.route)
//            else -> navController.navigate(route ?: destination.destination)
//        }
//    }
//
//    fun navigateUp() {
//        navController.popBackStack()
//    }
}