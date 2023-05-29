package com.toptop.provider.android.navigation

import com.toptop.provider.android.presentation.auth.login.LoginScreen
import com.toptop.provider.android.presentation.auth.sendCode.SendCodeScreen
import com.toptop.provider.android.presentation.onBoarding.OnBoardingScreen
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.core.LaunchFlag
import ru.alexgladkov.odyssey.core.animations.AnimationType

fun RootComposeBuilder.navigationGraph(onApplicationFinish: () -> Unit) {
    screen(NavigationTree.OnBoarding.name) {
        OnBoardingScreen(onApplicationFinish)
    }

    flow(NavigationTree.Auth.name) {
        screen(NavigationTree.Login.name) {
            LoginScreen()
        }
        screen(NavigationTree.SendCode.name) {
            SendCodeScreen()
        }
    }
}

fun RootController.navigate(
    screen: String,
    params: Any? = null,
    launchFlag: LaunchFlag? = null
) {
    launch(
        screen = screen,
        startScreen = null,
        startTabPosition = 0,
        params = params,
        animationType = AnimationType.Fade(200),
        launchFlag = launchFlag
    )
}

//fun RootComposeBuilder.mainScreen() {
//    bottomNavigation(name = NavigationTree.Main.name, tabsNavModel = CustomConfiguration()) {
//        tab(FeedTab()) {
//            screen(name = NavigationTree.Tab.name) {
//                TabScreen(it as? Int)
//            }
//        }
//        tab(SearchTab()) {
//            screen(name = NavigationTree.Tab.name) {
//                TabScreen(it as? Int)
//            }
//        }
//        tab(CartTab()) {
//            screen(name = NavigationTree.Tab.name) {
//                TabScreen(it as? Int)
//            }
//        }
//    }
//}
//
//class CustomConfiguration(
//    private val content: @Composable (params: Any?) -> Unit
//) : TabsNavModel<CustomNavConfiguration>() {
//
//    override val navConfiguration: CustomNavConfiguration
//        @Composable
//        get() {
//            return CustomNavConfiguration(
//                content = content
//            )
//        }
//}
