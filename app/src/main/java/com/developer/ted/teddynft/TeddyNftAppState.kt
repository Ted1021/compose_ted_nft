package com.developer.ted.teddynft

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

// app global state
// top level state hoisting
@Composable
fun rememberTeddyNftAppState(
    navigationController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(navigationController, coroutineScope) {
    TeddyNftAppState(navigationController, coroutineScope)
}


@Stable
class TeddyNftAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope
) {
}