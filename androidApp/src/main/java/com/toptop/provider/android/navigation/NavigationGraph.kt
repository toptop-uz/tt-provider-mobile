package com.toptop.provider.android.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.toptop.provider.android.presentation.auth.login.LoginScreen
import com.toptop.provider.android.presentation.auth.sendCode.SendCodeScreen
import com.toptop.provider.android.presentation.base.BaseScreenWrapper
import com.toptop.provider.android.presentation.onBoarding.OnBoardingScreen
import com.toptop.provider.android.presentation.selectLanguage.SelectLanguageScreen
import com.toptop.provider.presentation.selectLanguage.SelectLanguageViewModel
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.core.LaunchFlag
import ru.alexgladkov.odyssey.core.animations.AnimationType

fun RootComposeBuilder.navigationGraph(onApplicationFinish: () -> Unit) {
    screen(NavigationTree.SelectLanguage.name) {
        val viewModel = viewModel<SelectLanguageViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle().value

        BaseScreenWrapper(onApplicationFinish) { controller ->
            SelectLanguageScreen(
                state = state,
                onEvent = viewModel::onEvent,
                onNavigate = {
                    controller.navigate(
                        screen = it,
                        launchFlag = LaunchFlag.ClearPrevious
                    )
                }
            )
        }
    }

    screen(NavigationTree.OnBoarding.name) {
        BaseScreenWrapper(onApplicationFinish) { controller ->
            OnBoardingScreen {
                controller.navigate(
                    screen = it,
                    launchFlag = LaunchFlag.ClearPrevious
                )
            }
        }
    }

    flow(NavigationTree.Auth.name) {
        screen(NavigationTree.Login.name) {
            BaseScreenWrapper(onApplicationFinish) { controller ->
                LoginScreen { controller.navigate(it) }
            }
        }
        screen(NavigationTree.SendCode.name) {
            BaseScreenWrapper { controller ->
                SendCodeScreen { controller.navigate(it) }
            }
        }
    }
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

fun RootController.navigate(
    screen: NavigationTree,
    params: Any? = null,
    launchFlag: LaunchFlag? = null
) {
    launch(
        screen = screen.name,
        startScreen = null,
        startTabPosition = 0,
        params = params,
        animationType = AnimationType.Fade(200),
        launchFlag = launchFlag
    )
}