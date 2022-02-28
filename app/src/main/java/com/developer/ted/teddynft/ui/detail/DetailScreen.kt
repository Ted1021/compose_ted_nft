package com.developer.ted.teddynft.ui.detail

import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.drawColorShadow
import com.developer.ted.teddynft.common.textDp
import com.developer.ted.teddynft.component.StrokeImageButton

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailScreen() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.scrollable(state = scrollState, orientation = Orientation.Vertical)) {
        Spacer(modifier = Modifier.height(40.dp))
        DetailAppbar()
        Spacer(modifier = Modifier.height(44.dp))
        DetailContentImage(
            Modifier
                .fillMaxHeight()
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(50.dp))
        DetailBottomCard()
    }
}

@Composable
fun DetailAppbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 28.dp, end = 28.dp)
    ) {
        StrokeImageButton(
            res = R.drawable.ic_back,
            modifier = Modifier.align(Alignment.TopStart)
        )

        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            StrokeImageButton(
                res = R.drawable.ic_heart_light,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.width(15.dp))

            StrokeImageButton(
                res = R.drawable.ic_more_light,
                modifier = Modifier
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailContentImage(modifier: Modifier) {
    Image(
        painter = rememberImagePainter(R.drawable.img_gundam_nft),
        contentDescription = null,
        modifier = modifier
            .drawColorShadow(
                color = colorResource(R.color.black_opa08),
                shadowRadius = 60.dp,
                offsetY = 4.dp
            )
    )
}

@Composable
fun DetailBottomCard() {
    Surface(
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Spacer(modifier = Modifier.height(35.dp))
            BottomCardProfile()
            Spacer(modifier = Modifier.height(28.dp))
            BottomCardDesc()
            Spacer(modifier = Modifier.height(35.dp))
            BottomCardButtons()
            Spacer(modifier = Modifier.height(26.dp))
        }
    }
}

@Composable
fun BottomCardProfile() {
    Row(modifier = Modifier.padding(horizontal = 8.dp)) {
        Image(
            painter = rememberImagePainter(R.drawable.img_fake_profile),
            contentDescription = null,
            modifier = Modifier.size(size = 86.dp)
        )
        Spacer(modifier = Modifier.width(29.dp))
        Column {
            Text(
                text = "By Mekaverse",
                fontWeight = FontWeight.W600,
                fontSize = 16.textDp,
                color = colorResource(R.color.color_8d8d8d)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Meka #3199",
                fontWeight = FontWeight.W800,
                fontSize = 24.textDp,
                color = colorResource(R.color.black),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    text = "On sale for ",
                    fontWeight = FontWeight.W600,
                    fontSize = 20.textDp,
                    color = colorResource(R.color.color_8d8d8d)
                )
                Text(
                    text = "10 ETH",
                    fontWeight = FontWeight.W700,
                    fontSize = 20.textDp,
                    color = colorResource(R.color.primary_color)
                )
            }
        }
    }
}

@Composable
fun BottomCardDesc() {
    Column {
        Text(
            text = "Description",
            fontWeight = FontWeight.W700,
            fontSize = 18.textDp,
            color = colorResource(R.color.black)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Meka from the MekaVerse - A collection of 8,888 unique generative NFTs from an other universe. ",
            fontWeight = FontWeight.W500,
            fontSize = 16.textDp,
            color = colorResource(R.color.gray)
        )
    }
}

@Composable
fun BottomCardButtons() {
    Row(modifier = Modifier.fillMaxWidth()) {
        BottomCardButton(
            text = "Make Offer",
            textColorRes = R.color.white,
            backgroundColorRes = R.color.primary_color
        ) {
            // do nothing
        }
        Spacer(modifier = Modifier.width(15.dp))
        BottomCardButton(
            text = "Place Bid",
            textColorRes = R.color.white,
            backgroundColorRes = R.color.black
        ) {
            // do nothing
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomCardButton(
    text: String,
    @ColorRes textColorRes: Int,
    @ColorRes backgroundColorRes: Int,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(size = 18.dp),
        color = colorResource(backgroundColorRes),
        onClick = { onClick.invoke() }
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.W700,
            fontSize = 18.textDp,
            color = colorResource(textColorRes),
            modifier = Modifier.padding(horizontal = 45.dp, vertical = 22.dp),
            textAlign = TextAlign.Center
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF,
    widthDp = 414,
    heightDp = 896
)
@Composable
fun PreviewDetailAppbar() {
    DetailScreen()
}