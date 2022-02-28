package com.developer.ted.teddynft.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.textDp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun IntroScreen() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.bg_intro_screen),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )

        BottomCard(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@ExperimentalPagerApi
@Composable
fun BottomCard(modifier: Modifier) {
    val pagerState = rememberPagerState()

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(color = colorResource(R.color.white))
            .height(374.dp)
            .fillMaxWidth()
    ) {
        IntroCardIndicator(
            pagerState,
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 33.dp, bottom = 41.dp)
        )

        IntroCardContentList(pagerState)

        IntroCardButton()
    }
}

@ExperimentalPagerApi
@Composable
fun IntroCardIndicator(
    pagerState: PagerState,
    modifier: Modifier
) {
    LazyRow(modifier = modifier) {
        items(3) { idx ->
            val dotRes = if (idx == pagerState.currentPage) R.drawable.indicator_dot_enabled
            else R.drawable.indicator_dot_disabled

            if (idx != 0) Spacer(modifier = Modifier.width(4.57.dp))

            Image(
                painter = rememberImagePainter(dotRes),
                contentDescription = null,
                modifier = Modifier.size(7.6.dp)
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun IntroCardContentList(pagerState: PagerState) {
    HorizontalPager(count = 3, state = pagerState) {
        CardContent()
    }
}

@Composable
fun CardContent() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Discover Rare Collectibles",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.textDp,
            color = colorResource(R.color.black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 90.dp, end = 90.dp, bottom = 20.dp)
        )

        Text(
            text = "Buy and Sell Rare Collectibles from Top Artists",
            fontSize = 16.textDp,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.dark_gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 41.dp)
        )
    }
}

@Composable
fun IntroCardButton() {
    Surface(
        color = colorResource(R.color.primary_color),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
            .clickable { }
    ) {
        Text(
            text = "Explore NFTs",
            color = colorResource(R.color.white),
            fontSize = 20.textDp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .height(75.dp)
                .wrapContentSize()
        )
    }
}


@ExperimentalPagerApi
@Preview(
    widthDp = 414,
    heightDp = 896
)
@Composable
fun PreviewIntroScreen() {
    IntroScreen()
}
