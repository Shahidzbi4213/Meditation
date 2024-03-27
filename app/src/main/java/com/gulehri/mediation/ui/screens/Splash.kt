package com.gulehri.mediation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.gulehri.mediation.R
import com.gulehri.mediation.ui.screens.destinations.OnBoardingScreenDestination
import com.gulehri.mediation.ui.screens.destinations.SplashScreenDestination
import com.gulehri.mediation.ui.utils.Extensions.navigateNext
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

/*
 * Created by Shahid Iqbal on 3/24/2024.
 */

@Destination(start = true)
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {


    LaunchedEffect(key1 = Unit) {

        delay(3000)
        navigator.navigateNext(
            current = SplashScreenDestination,
            next = OnBoardingScreenDestination,
            canPopup = true,
            inclusive = true
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}