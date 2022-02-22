package com.developer.ted.teddynft.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun Seller() {
    Surface(
        shape = RoundedCornerShape(24.dp),
        color = colorResource(id = R.color.seller_background_color)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = rememberImagePainter(R.drawable.img_sample_profile),
                contentDescription = null,
                modifier = Modifier
                    .size(54.dp)
                    .align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "THE WATCHER",
                    fontSize = 16.textDp,
                    fontWeight = FontWeight.W700,
                    color = colorResource(R.color.black)
                )

                Text(
                    text = "$739,420",
                    fontSize = 16.textDp,
                    fontWeight = FontWeight.W600,
                    color = colorResource(R.color.light_gray)
                )
            }

            Text(
                text = "Follow",
                fontSize = 16.textDp,
                fontWeight = FontWeight.W700,
                color = colorResource(R.color.primary_color),
                modifier = Modifier
                    .padding(end = 44.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSeller() {
    Seller()
}