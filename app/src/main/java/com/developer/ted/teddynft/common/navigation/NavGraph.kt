package com.developer.ted.teddynft.common.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.developer.ted.teddynft.ui.detail.DetailScreen
import com.developer.ted.teddynft.ui.intro.IntroScreen
import com.developer.ted.teddynft.ui.main.MainScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalPagerApi
@ExperimentalMaterialApi
fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    composable(route = Screen.Intro.routeFormat) {
        IntroScreen { userId -> navController.navigate(route = Screen.Main.getActualRoute(userId)) }
    }

    composable(
        route = Screen.Main.routeFormat,
        arguments = Screen.Main.arguments
    ) { backStackEntry ->
        backStackEntry.arguments?.getLong(ParamKey.USER_ID)?.let { userId ->
            MainScreen(userId) { nftId -> navController.navigate(route = Screen.Detail.getActualRoute(nftId)) }
        }
    }

    composable(
        route = Screen.Detail.routeFormat,
        arguments = Screen.Detail.arguments
    ) { backStackEntry ->
        backStackEntry.arguments?.getLong(ParamKey.NFT_ID)?.let { nftId -> DetailScreen(nftId) }
    }
}