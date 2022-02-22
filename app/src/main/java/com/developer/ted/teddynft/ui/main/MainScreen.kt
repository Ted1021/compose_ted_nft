package com.developer.ted.teddynft.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@ExperimentalPagerApi
@Composable
fun MainScreen() {
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        InfoHeader()
        Spacer(modifier = Modifier.height(44.dp))
        Categories()
        Spacer(modifier = Modifier.height(49.dp))
        Features()
        Spacer(modifier = Modifier.height(40.dp))
        TopSellers()
    }
}

@Composable
fun InfoHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
    ) {
        Image(
            painter = rememberImagePainter(R.drawable.ic_eth),
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

        StrokeImageButton(res = R.drawable.ic_search_normal)

        Spacer(modifier = Modifier.width(15.dp))

        StrokeImageButton(res = R.drawable.ic_notification)
    }
}

@Composable
fun Categories() {
    Carousel(
        title = MainScreenCarousel.CATEGORIES.title,
        titlePadding = 20.dp,
        onViewAllClicked = {},
        modifier = Modifier
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            val categories = listOf("Art", "Music", "Games", "Domains")
            Row(modifier = Modifier.align(Alignment.Center)) {
                categories.forEachIndexed { idx, value ->
                    if (idx != 0) Spacer(Modifier.width(12.dp))
                    StrokeTextButton(text = value)
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun Features() {
    val pagerState = rememberPagerState()
    Carousel(
        title = MainScreenCarousel.FEATURES.title,
        titlePadding = 20.dp,
        onViewAllClicked = {},
        modifier = Modifier
    ) {
        HorizontalPager(
            count = 3,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 44.dp)
        ) {
            Card()
        }
    }
}

@Composable
fun TopSellers() {
    Carousel(
        title = MainScreenCarousel.TOP_SELLERS.title,
        titlePadding = 20.dp,
        onViewAllClicked = {},
        modifier = Modifier
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Seller()
            Spacer(modifier = Modifier.height(5.dp))
            Seller()
            Spacer(modifier = Modifier.height(5.dp))
            Seller()
        }
    }
}


@ExperimentalPagerApi
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
    widthDp = 414,
    heightDp = 896
)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}

enum class MainScreenCarousel(val title: String) {
    CATEGORIES("Categories"),
    FEATURES("Featured NFTs"),
    TOP_SELLERS("Top Sellers")
}