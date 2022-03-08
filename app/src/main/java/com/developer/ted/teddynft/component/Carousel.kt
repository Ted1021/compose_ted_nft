package com.developer.ted.teddynft.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.textDp
import com.developer.ted.teddynft.ui.main.MainScreenCarousel
import com.developer.ted.teddynft.ui.main.MainScreenClickEvent

@Composable
fun Carousel(
    title: String,
    onViewAllClicked: (MainScreenClickEvent) -> Unit,
    titlePadding: Dp,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        CarouselTitle(title, titlePadding, onViewAllClicked)
        Spacer(modifier = Modifier.height(23.dp))
        content()
    }
}

@Composable
fun CarouselTitle(
    title: String,
    titlePadding: Dp,
    onViewAllClicked: (MainScreenClickEvent) -> Unit
) {
    Row(Modifier.padding(horizontal = titlePadding)) {
        Text(
            text = title,
            fontWeight = FontWeight.W700,
            fontSize = 20.textDp,
            color = colorResource(id = R.color.black),
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "View all",
            fontWeight = FontWeight.W600,
            fontSize = 18.textDp,
            color = colorResource(R.color.gray),
            modifier = Modifier.clickable {
                onViewAllClicked.invoke(
                    MainScreenClickEvent.ViewAll(
                        MainScreenCarousel.valueOf(
                            title
                        )
                    )
                )
            }
        )
    }
}

enum class ContentOrientation {
    HORIZONTAL, VERTICAL
}