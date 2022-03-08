package com.developer.ted.teddynft.component

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.textDp

@ExperimentalMaterialApi
@Composable
fun StrokeImageButton(
    @DrawableRes res: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
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

@Composable
fun SelectableTextButton(
    text: String,
    selected: Boolean = false,
    onCategoryClicked: ((String) -> Unit)? = null
) {
    val fontColor = colorResource(if (selected) R.color.white else R.color.black)
    val surfaceColor = colorResource(if (selected) R.color.primary_color else R.color.white)
    val strokeColor = colorResource(if (selected) R.color.primary_color else R.color.light_gray)

    Surface(
        color = surfaceColor,
        border = BorderStroke(width = 1.dp, color = strokeColor),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier
            .height(35.dp)
            .clickable { onCategoryClicked?.invoke(text) }
    ) {
        Text(
            text = text,
            fontSize = 14.textDp,
            fontWeight = FontWeight.W600,
            color = fontColor,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun RoundedTextButton(
    radius: Dp = 12.dp,
    @ColorRes buttonColorRes: Int = R.color.primary_color,
    @ColorRes textColorRes: Int = R.color.white,
    text: String,
    fontSize: TextUnit = 20.textDp,
    fontWeight: FontWeight = FontWeight.Bold,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(size = radius),
        backgroundColor = colorResource(buttonColorRes),
        modifier = modifier
    ) {
        Box(modifier = Modifier.clickable { onClick.invoke() }) {
            Text(
                text = text,
                color = colorResource(textColorRes),
                fontSize = fontSize,
                fontWeight = fontWeight,
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(75.dp)
                    .wrapContentSize()
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF
)
@Composable
private fun PreviewStrokeTextButtonSelected() {
    SelectableTextButton(text = "Test", selected = true)
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF
)
@Composable
private fun PreviewStrokeTextButtonNotSelected() {
    SelectableTextButton(text = "Test", selected = false)
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PreviewImageButton() {
    StrokeImageButton(res = R.drawable.ic_notification) {}
}