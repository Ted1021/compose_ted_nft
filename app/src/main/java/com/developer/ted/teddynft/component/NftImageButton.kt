package com.developer.ted.teddynft.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R

@Composable
fun StrokeImageButton(
    @DrawableRes res: Int,
    modifier: Modifier
) {
    Surface(
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.light_gray)),
        shape = RoundedCornerShape(12.dp),
        color = colorResource(R.color.white)
    ) {
        Image(
            painter = rememberImagePainter(res),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .size(22.dp)
        )
    }
}

@Preview
@Composable
fun PreviewImageButton() {
    StrokeImageButton(res = R.drawable.ic_notification, Modifier)
}