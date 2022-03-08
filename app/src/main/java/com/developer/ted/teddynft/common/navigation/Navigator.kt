package com.developer.ted.teddynft.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.lifecycle.Lifecycle
import androidx.navigation.*
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberNavigator(
    navigationController: NavHostController = rememberNavController()
) = AppNavigator(navigationController)

@Stable
class AppNavigator(val navController: NavHostController) {
    val currentBackStackEntry: NavBackStackEntry?
        get() = navController.currentBackStackEntry

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun onBackPressed() {
        navController.navigateUp()
    }

    fun navigateToIntro() {
        navController.navigate(route = Screen.Intro.routeFormat)
    }

    fun navigateToMain(userId: Long) {
        navController.navigate(route = Screen.Main.getActualRoute(userId))
    }

    fun navigateToDetail(nftId: Long) {
        navController.navigate(route = Screen.Detail.getActualRoute(nftId))
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

/**
 * Copied from similar function in NavigationUI.kt
 *
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-ui/src/main/java/androidx/navigation/ui/NavigationUI.kt
 */
private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}