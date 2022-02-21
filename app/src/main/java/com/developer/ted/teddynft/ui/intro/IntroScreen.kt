package com.developer.ted.teddynft.ui.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.textDp

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

        BottomCard(
            Modifier
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(color = colorResource(R.color.white))
                .align(Alignment.BottomCenter)
                .height(374.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun BottomCard(modifier: Modifier) {
    val currentIdx by remember { mutableStateOf(0) }
    Column(modifier = modifier) {
        CardIndicator(
            currentIdx,
            Modifier
                .padding(top = 33.dp, bottom = 41.dp)
                .align(Alignment.CenterHorizontally)
        )

        CardContent()
        // CardContentList()
    }
}

@Composable
fun CardIndicator(
    currentIdx: Int = 0,
    modifier: Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(4.57.dp),
        modifier = modifier
    ) {
        items(3) { idx ->
            val dotRes =
                if (idx == currentIdx) R.drawable.indicator_dot_enabled
                else R.drawable.indicator_dot_disabled

            Image(
                painter = rememberImagePainter(R.drawable.indicator_dot_disabled),
                contentDescription = null,
                modifier = Modifier.size(7.6.dp)
            )
        }
    }
}

@Composable
fun CardContentList() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(3) {
            CardContent()
        }
    }
}

@Composable
fun CardContent() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Discover Rare Collectibles",
            textAlign = TextAlign.Center,
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

        Text(
            text = "Explore NFTs",
            color = colorResource(id = R.color.white),
            fontSize = 20.textDp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(size = 12.dp))
                .padding(horizontal = 28.dp)
                .background(color = colorResource(R.color.primary_color))
                .height(75.dp)
                .fillMaxWidth()
        )
    }
}


@Preview
@Composable
fun PreviewIntroScreen() {
    IntroScreen()
}
