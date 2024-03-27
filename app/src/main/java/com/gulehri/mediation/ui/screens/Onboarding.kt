package com.gulehri.mediation.ui.screens;

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gulehri.mediation.R
import com.gulehri.mediation.ui.screens.destinations.OnBoardingScreenDestination
import com.gulehri.mediation.ui.theme.PrimaryContainer
import com.gulehri.mediation.ui.theme.Typography
import com.gulehri.mediation.ui.utils.Extensions.navigateNext
import com.gulehri.mediation.ui.utils.NoRippleInteractionSource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/*
 * Created by Shahid Iqbal on 3/26/2024.
 */

@Destination
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
) {


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .scrollable(
                    rememberScrollState(),
                    orientation = Orientation.Vertical
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            Text(
                text = stringResource(id = R.string.welcome)
                    .uppercase(),
                style = Typography.titleLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.stay_focused),
                style = Typography.titleMedium,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(0.7f)
            )

            Spacer(modifier = Modifier.height(40.dp))


            Button(
                onClick = {
                    /*navigator.navigateNext(
                        current = OnBoardingScreenDestination,
                        next =,
                        canPopup = true,
                        inclusive = true
                    )*/
                },
                interactionSource = NoRippleInteractionSource(),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryContainer,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(55.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.login_with_email),
                    style = Typography
                        .bodyMedium
                        .copy(fontSize = 25.sp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(id = R.string.not_having_account),
                    style = Typography.bodyMedium,
                    color = Color.White
                )

                Text(
                    text = stringResource(id = R.string.sign_up),
                    style = Typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    ),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

        }
    }
}