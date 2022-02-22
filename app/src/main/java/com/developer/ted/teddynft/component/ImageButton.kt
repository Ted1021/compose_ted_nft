package com.developer.ted.teddynft.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R

@Composable
fun StrokeImageButton(@DrawableRes res: Int) {
    Surface(
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.light_gray)),
        modifier = Modifier.size(width = 48.dp, height = 46.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Image(
            painter = rememberImagePainter(res),
            contentDescription = null,
            modifier = Modifier.size(22.dp)
        )
    }
}