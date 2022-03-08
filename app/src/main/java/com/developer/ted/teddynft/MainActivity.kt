package com.developer.ted.teddynft

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.developer.ted.teddynft.ui.detail.DetailScreen
import com.developer.ted.teddynft.ui.intro.IntroScreen
import com.developer.ted.teddynft.ui.main.MainScreen
import com.developer.ted.teddynft.ui.theme.TeddyNFTTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           TeddyNftApp()
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TeddyNFTTheme {
       MainScreen(0) {}
    }
}