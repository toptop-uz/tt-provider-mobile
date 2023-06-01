package com.toptop.provider.android.navigation

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.toptop.provider.android.designsystem.theme.ColorOnBackground
import com.toptop.provider.android.designsystem.theme.TTTheme
import com.toptop.provider.data.model.type.EntryType
import com.toptop.provider.data.model.type.LanguageType

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TTApp(
    entry: EntryType,
    language: LanguageType,
    appState: TTAppState = rememberTTAppState()
) {
    TTTheme(language = language) {
        Scaffold(
            containerColor = Color.Transparent,
            contentColor = ColorOnBackground,
            bottomBar = {
//                TTBottomBar(
//                    destinations = appState.topLevelDestinations,
//                    onNavigateToRoute = appState::navigate,
//                    currentDestination = appState.currentDestination
//                )
            }
        ) { padding ->
            TTNavHost(
                navController = appState.navController,
                modifier = Modifier
                    .padding(padding)
                    .consumeWindowInsets(padding),
                startDestination = when (entry) {
                    EntryType.Auth -> NavigationTree.SelectLanguage.name
                    EntryType.Dashboard -> NavigationTree.Dashboard.name
                }
            )
        }
    }
}

//@Composable
//private fun TTBottomBar(
//    destinations: List<TopLevelDestination>,
//    onNavigateToRoute: SingleBlock<TopLevelDestination>,
//    currentDestination: NavDestination?
//) {
//    val currentRoute = currentDestination?.route
//
//    AnimatedVisibility(
//        visible = currentRoute in destinations.map { it.route },
//        enter = expandVertically(),
//        exit = shrinkVertically()
//    ) {
//        Surface {
//            MuslimNavigationBar(
//                modifier = Modifier.windowInsetsPadding(
//                    WindowInsets.safeDrawing.only(
//                        WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
//                    )
//                )
//            ) {
//                destinations.forEach { destination ->
//                    val selected =
//                        currentDestination?.hierarchy?.any { it.route == destination.route } == true
//                    MuslimNavigationBarItem(
//                        selected = selected,
//                        onClick = { onNavigateToRoute(destination) },
//                        icon = {
//                            val icon = if (selected) {
//                                destination.selectedIcon
//                            } else {
//                                destination.unselectedIcon
//                            }
//                            MuslimIcon(imageVector = icon)
//                        },
//                        label = {
//                            Text(
//                                text = stringResource(destination.iconTextId),
//                                style = BodyMedium,
//                                fontSize = 13.sp
//                            )
//                        }
//                    )
//                }
//            }
//        }
//    }
//}