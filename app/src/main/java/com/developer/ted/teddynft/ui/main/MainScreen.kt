package com.developer.ted.teddynft.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.textDp
import com.developer.ted.teddynft.component.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun MainScreen(
    userId: Long,
    navigateToDetail: (nftId: Long) -> Unit
) {

    val clickEvents = { action: MainScreenClickEvent ->
        when (action) {
            is MainScreenClickEvent.PlaceBid -> {
                navigateToDetail.invoke(action.nftId)
            }

            // TODO
            is MainScreenClickEvent.Notification -> {}
            is MainScreenClickEvent.Search -> {}
            is MainScreenClickEvent.Seller -> {}
            is MainScreenClickEvent.Like -> {}
            is MainScreenClickEvent.Category -> {}
            is MainScreenClickEvent.ViewAll -> {}
        }
    }
    LazyColumn(
        contentPadding = PaddingValues(bottom = 40.dp),
        modifier = Modifier
    ) {
        item {
            Spacer(modifier = Modifier.height(40.dp))
            InfoHeader(clickEvents)
            Spacer(modifier = Modifier.height(44.dp))
            Categories(clickEvents)
            Spacer(modifier = Modifier.height(49.dp))
            Features(clickEvents)
            Spacer(modifier = Modifier.height(40.dp))
            TopSellers(clickEvents)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun InfoHeader(onClick: (MainScreenClickEvent) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
    ) {
        Image(
            painter = rememberImagePainter(R.drawable.ic_cryptocurrency),
            contentDescription = null,
            modifier = Modifier.size(33.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = "8.42 ETH",
            fontSize = 24.textDp,
            fontWeight = FontWeight.ExtraBold,
            color = colorResource(R.color.black),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(15.dp))

        StrokeImageButton(res = R.drawable.ic_search_normal) { onClick.invoke(MainScreenClickEvent.Search) }

        Spacer(modifier = Modifier.width(15.dp))

        StrokeImageButton(res = R.drawable.ic_notification) { onClick.invoke(MainScreenClickEvent.Notification) }
    }
}


@Composable
fun Categories(itemClickListener: (MainScreenClickEvent) -> Unit) {
    Carousel(
        title = MainScreenCarousel.CATEGORIES.title,
        titlePadding = 20.dp,
        onViewAllClicked = itemClickListener,
        modifier = Modifier
    ) {
        var currentCategory by remember { mutableStateOf("Art") }

        Box(modifier = Modifier.fillMaxWidth()) {
            val categories = listOf("Art", "Music", "Games", "Domains")
            Row(modifier = Modifier.align(Alignment.Center)) {
                categories.forEachIndexed { idx, value ->
                    if (idx != 0) Spacer(Modifier.width(12.dp))
                    SelectableTextButton(
                        text = value,
                        selected = currentCategory == value
                    ) { currentCategory = it }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun Features(itemClickListener: (MainScreenClickEvent) -> Unit) {
    val pagerState = rememberPagerState()
    Carousel(
        title = MainScreenCarousel.FEATURES.title,
        titlePadding = 20.dp,
        onViewAllClicked = itemClickListener,
        modifier = Modifier
    ) {
        HorizontalPager(
            count = 3,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 28.dp)
        ) {
            NftCard(itemClickListener = itemClickListener)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TopSellers(itemClickListener: (MainScreenClickEvent) -> Unit) {
    Carousel(
        title = MainScreenCarousel.TOP_SELLERS.title,
        titlePadding = 20.dp,
        onViewAllClicked = itemClickListener,
        modifier = Modifier
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            (0..4).forEachIndexed { idx, _ ->
                if (idx != 0) Spacer(modifier = Modifier.height(5.dp))
                Seller(onSellerClicked = itemClickListener)
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
    widthDp = 414,
    heightDp = 896
)
@Composable
fun PreviewMainScreen() {
    MainScreen(0) {}
}

enum class MainScreenCarousel(val title: String) {
    CATEGORIES("Categories"),
    FEATURES("Featured NFTs"),
    TOP_SELLERS("Top Sellers")
}