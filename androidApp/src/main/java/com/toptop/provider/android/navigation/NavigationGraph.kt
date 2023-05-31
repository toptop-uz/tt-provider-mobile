package com.toptop.provider.android.navigation

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.toptop.provider.android.presentation.auth.login.LoginScreen
import com.toptop.provider.android.presentation.auth.sendCode.SendCodeScreen
import com.toptop.provider.android.presentation.selectLanguage.SelectLanguageScreen
import com.toptop.provider.presentation.auth.login.LoginViewModel
import com.toptop.provider.presentation.auth.sendCode.SendCodeViewModel
import com.toptop.provider.presentation.selectLanguage.SelectLanguageViewModel

fun NavGraphBuilder.selectLanguageGraph(
    controller: NavHostController
) {
    composable(route = NavigationTree.SelectLanguage.name) {
        val viewModel = viewModel<SelectLanguageViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle().value

        SelectLanguageScreen(
            state = state,
            onEvent = viewModel::onEvent,
            onNavigate = controller::navigateTo
        )
    }
}

fun NavGraphBuilder.authGraph(
    controller: NavHostController
) {
    navigation(
        route = NavigationTree.Auth.name,
        startDestination = NavigationTree.Login.name
    ) {
        composable(route = NavigationTree.Login.name) {
            val viewModel = viewModel<LoginViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value

            LoginScreen(
                state = state,
                onEvent = viewModel::onEvent,
                onNavigate = controller::navigateTo
            )
        }
        composable(route = NavigationTree.SendCode.name) {
            val viewModel = viewModel<SendCodeViewModel>()
            val state = viewModel.state.collectAsStateWithLifecycle().value

            SendCodeScreen(
                state = state,
                onEvent = viewModel::onEvent,
                onNavigate = {}
            )
        }
    }
}