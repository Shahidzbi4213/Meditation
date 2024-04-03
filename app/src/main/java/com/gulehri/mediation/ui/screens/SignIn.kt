package com.gulehri.mediation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gulehri.mediation.R
import com.gulehri.mediation.ui.components.MeditationTextField
import com.gulehri.mediation.ui.screens.destinations.SignInScreenDestination
import com.gulehri.mediation.ui.screens.destinations.SignUpScreenDestination
import com.gulehri.mediation.ui.theme.HintColor
import com.gulehri.mediation.ui.theme.MainColor
import com.gulehri.mediation.ui.theme.PrimaryContainer
import com.gulehri.mediation.ui.theme.Typography
import com.gulehri.mediation.ui.utils.Extensions.navigateNext
import com.gulehri.mediation.ui.utils.Extensions.noRippleClickable
import com.gulehri.mediation.ui.utils.NoRippleInteractionSource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/*
 * Created by Shahid Iqbal on 3/27/2024.
 */


@OptIn(ExperimentalComposeUiApi::class)
@Destination
@Composable
fun SignInScreen(
    viewModel: SignInViewModel = viewModel(),
    navigator: DestinationsNavigator,
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val textSelectionColors =
        TextSelectionColors(handleColor = HintColor, backgroundColor = HintColor)
    val focusRequester = remember {
        FocusRequester()
    }
    val softKeyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MainColor)
            .noRippleClickable {
                softKeyboardController?.hide()
            }
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.leaves
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    start = 30.dp,
                    top = 70.dp
                )
                .scrollable(
                    rememberScrollState(),
                    Orientation.Vertical
                )
        ) {


            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.sigin),
                style = Typography.titleMedium.copy(
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.sigin_now),
                style = Typography.bodyMedium.copy(
                    color = HintColor,
                ), modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .wrapContentWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))


            CompositionLocalProvider(value = LocalTextSelectionColors provides textSelectionColors) {
                MeditationTextField(
                    value = uiState.email,
                    onChange = viewModel::updateEmail,
                    labelText = stringResource(id = R.string.email_address),
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 5.dp)
                )
            }



            Spacer(modifier = Modifier.height(40.dp))

            MeditationTextField(
                value = uiState.password,
                onChange = viewModel::updatePassword,
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
                labelText = stringResource(id = R.string.password),
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .padding(horizontal = 5.dp),
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.forgot_password),
                style = Typography.bodySmall.copy(color = HintColor),
                modifier = Modifier.fillMaxWidth(0.9f),
                textAlign = TextAlign.End
            )


            Spacer(modifier = Modifier.height(80.dp))


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
                    .height(50.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.login),
                    style = Typography
                        .bodyMedium
                        .copy(fontSize = 25.sp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))


            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(0.87f)
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
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .noRippleClickable {
                            navigator.navigateNext(
                                current = SignInScreenDestination,
                                next = SignUpScreenDestination,
                                canPopup = true,
                                inclusive = true
                            )
                        }
                )
            }
        }
    }
}