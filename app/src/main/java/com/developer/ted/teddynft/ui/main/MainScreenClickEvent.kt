package com.developer.ted.teddynft.ui.main

sealed class MainScreenClickEvent {
    data class PlaceBid(val nftId: Long) : MainScreenClickEvent()
    object Like : MainScreenClickEvent()
    object Search : MainScreenClickEvent()
    object Notification : MainScreenClickEvent()
    object Seller: MainScreenClickEvent()
    data class ViewAll(val type: MainScreenCarousel) : MainScreenClickEvent()
    data class Category(val typ: Category): MainScreenClickEvent()
}

enum class CategoryType(type: String) {
    ART("Art"),
    MUSIC("Music"),
    GAMES("Games"),
    DOMAINS("Domains")
}