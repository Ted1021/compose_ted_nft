package com.developer.ted.teddynft.common.navigation

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object ParamKey {
    const val USER_ID = "userId"
    const val NFT_ID = "nftId"
}

sealed class Screen(
    name: String,
    vararg args: NavParam
) {
    val routeFormat: String = name.toRoute(args)
    val arguments: List<NamedNavArgument> = args.map { it.navArg }
    var actualRoute: String = ""

    object Intro : Screen(name = "intro")

    /*
    1. format = internal://main/{userId}
    2. actualRoute = internal://main/12345
     */

    object Main : Screen(
        "main",
        NavParam(
            paramType = ParamType.MANDATORY,
            navArg = navArgument(ParamKey.USER_ID) {
                defaultValue = 0
                type = NavType.LongType
            }
        )
    ) {
        fun getActualRoute(userId: Long): String = routeFormat.bindParam(ParamKey.USER_ID, userId)
    }

    object Detail : Screen(
        name = "detail",
        NavParam(
            paramType = ParamType.MANDATORY,
            navArg = navArgument(ParamKey.NFT_ID) {
                defaultValue = 1
                type = NavType.LongType
            }
        )
    ) {
        fun getActualRoute(nftId: Long): String = routeFormat.bindParam(ParamKey.NFT_ID, nftId)
    }
}

data class NavParam(
    val paramType: ParamType = ParamType.MANDATORY,
    val navArg: NamedNavArgument
)

enum class ParamType {
    MANDATORY,  // as path
    OPTIONAL    // as query
}

private fun String.toRoute(args: Array<out NavParam>): String = Uri.parse("internal://$this")
    .buildUpon()
    .apply {
        args.forEach { arg ->
            with(arg.navArg.name) {
                when (arg.paramType) {
                    ParamType.MANDATORY -> appendPath("{$this}")
                    ParamType.OPTIONAL -> appendQueryParameter(this, "{$this}")
                }
            }
        }
    }
    .build()
    .toString()

private fun String.bindParam(key: String, value: Any) = this.replace("{$key}}", "$value")

