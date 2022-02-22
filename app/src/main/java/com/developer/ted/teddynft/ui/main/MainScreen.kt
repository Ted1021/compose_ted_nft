package com.developer.ted.teddynft.ui.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
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

@Composable
fun MainScreen() {
    Column {
        Info()
        Categories()
        Features()
        TopSellers()
    }

}

@Composable
fun Info() {
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
fun StrokeImageButton(@DrawableRes res: Int) {
    Surface(
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.light_gray)),
        modifier = Modifier.size(width = 48.dp, height = 46.dp)
    ) {
        Image(
            painter = rememberImagePainter(res),
            contentDescription = null,
            modifier = Modifier.size(22.dp)
        )
    }
}

@Composable
fun Categories() {

}

@Composable
fun Features() {

}

@Composable
fun TopSellers() {

}


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