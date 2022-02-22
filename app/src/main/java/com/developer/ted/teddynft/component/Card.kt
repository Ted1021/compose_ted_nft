package com.developer.ted.teddynft.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.textDp

@Composable
fun Card() {
    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
        CardContent(modifier = Modifier.padding(bottom = 32.dp))
        CardButtons(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun CardContent(modifier: Modifier) {
    Surface(
        shape = RoundedCornerShape(40.dp),
        color = colorResource(R.color.card_background_color),
        elevation = 4.dp,
        modifier = modifier
            .wrapContentWidth()
    ) {
        Column(
            modifier = Modifier.wrapContentWidth()
        ) {
            Image(
                painter = rememberImagePainter(R.drawable.img_gundam_nft),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(310.dp)
            )

            Box(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 42.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.align(Alignment.CenterStart)) {
                    Text(
                        text = "By MekaVerse",
                        fontSize = 14.textDp,
                        fontWeight = FontWeight.W500,
                        color = colorResource(R.color.gray)
                    )
                    Text(
                        text = "Meka #3139",
                        fontSize = 18.textDp,
                        fontWeight = FontWeight.W700,
                        color = colorResource(R.color.black)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Text(
                        text = "Current Price",
                        fontSize = 14.textDp,
                        fontWeight = FontWeight.W500,
                        color = colorResource(R.color.gray)
                    )
                    Text(
                        text = "10 ETH",
                        fontSize = 18.textDp,
                        fontWeight = FontWeight.W700,
                        color = colorResource(R.color.black)
                    )
                }
            }
        }
    }

}

@Composable
fun CardButtons(modifier: Modifier) {
    Row(modifier = modifier) {
        Surface(
            shape = RoundedCornerShape(18.dp),
            color = colorResource(id = R.color.black)
        ) {
            Text(
                text = "Place Bid",
                color = colorResource(id = R.color.white),
                fontSize = 16.textDp,
                fontWeight = FontWeight.W600,
                modifier = Modifier.padding(horizontal = 44.dp, vertical = 18.dp)
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Surface(
            shape = RoundedCornerShape(18.dp),
            color = colorResource(id = R.color.primary_color)
        ) {
            Image(
                painter = rememberImagePainter(R.drawable.ic_heart),
                contentDescription = null,
                modifier = Modifier
                    .padding(18.dp)
                    .size(22.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    Card()
}