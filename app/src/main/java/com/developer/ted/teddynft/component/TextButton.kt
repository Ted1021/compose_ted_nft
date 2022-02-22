package com.developer.ted.teddynft.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developer.ted.teddynft.R
import com.developer.ted.teddynft.common.textDp

@Composable
fun StrokeTextButton(
    text: String,
    selected: Boolean = false
) {
    val fontColor = colorResource(if (selected) R.color.white else R.color.black)
    val surfaceColor = colorResource(if (selected) R.color.primary_color else R.color.white)
    val strokeColor = colorResource(if (selected) R.color.primary_color else R.color.light_gray)

    Surface(
        color = surfaceColor,
        border = BorderStroke(width = 1.dp, color = strokeColor),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = Modifier.height(35.dp)
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

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF
)
@Composable
private fun PreviewStrokeTextButtonSelected() {
    StrokeTextButton(text = "Test", selected = true)
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFF
)
@Composable
private fun PreviewStrokeTextButtonNotSelected() {
    StrokeTextButton(text = "Test", selected = false)
}