package com.developer.ted.teddynft.ui.intro

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
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
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_intro_screen),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )

        BottomCard(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@ExperimentalPagerApi
@Composable
fun BottomCard(modifier: Modifier) {
    val context = LocalContext.current
    val pagerState = rememberPagerState()

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(color = colorResource(R.color.white))
            .height(374.dp)
            .fillMaxWidth()
    ) {
        CardIndicator(
            pagerState,
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 33.dp, bottom = 41.dp)
        )

        CardContentList(pagerState) {
            Toast.makeText(context, "wow! ${pagerState.currentPage}", Toast.LENGTH_SHORT).show()
        }
    }
}

@ExperimentalPagerApi
@Composable
fun CardIndicator(
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
fun CardContentList(
    pagerState: PagerState,
    onButtonClicked: () -> Unit
) {
    HorizontalPager(
        count = 3,
        state = pagerState
    ) {
        CardContent(onButtonClicked)
    }
}

@Composable
fun CardContent(onButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .fillMaxHeight()
    ) {
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

        Box(
            modifier = Modifier
                .padding(horizontal = 28.dp)
                .height(75.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(size = 12.dp))
                .background(color = colorResource(R.color.primary_color))
                .clickable { onButtonClicked.invoke() }
        ) {
            Text(
                text = "Explore NFTs",
                color = colorResource(id = R.color.white),
                fontSize = 20.textDp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
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
