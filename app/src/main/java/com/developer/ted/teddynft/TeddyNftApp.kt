package com.developer.ted.teddynft

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.developer.ted.teddynft.common.navigation.Screen
import com.developer.ted.teddynft.common.navigation.appNavGraph
import com.developer.ted.teddynft.common.navigation.rememberNavigator
import com.developer.ted.teddynft.ui.theme.TeddyNFTTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun TeddyNftApp() {
    TeddyNFTTheme {
        val navigator = rememberNavigator()

        NavHost(
            navController = navigator.navController,
            startDestination = Screen.Intro.routeFormat
        ) {
            appNavGraph(
                toMain = { userId -> navigator.navigateToMain(userId) },
                toDetail = { nftId -> navigator.navigateToDetail(nftId) }
            )
        }
    }
}