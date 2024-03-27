package com.gulehri.mediation.ui.screens;

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gulehri.mediation.R
import com.gulehri.mediation.ui.theme.HintColor
import com.gulehri.mediation.ui.theme.MainColor
import com.gulehri.mediation.ui.theme.MediationTheme
import com.gulehri.mediation.ui.theme.PrimaryContainer
import com.gulehri.mediation.ui.theme.Typography
import kotlin.math.sin

/*
 * Created by Shahid Iqbal on 3/27/2024.
 */


@Preview
@Composable
fun SignInScreen() {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MainColor)
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
                .fillMaxHeight(0.6f)
                .padding(
                    start = 35.dp, top = 70.dp
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
                text = stringResource(id = R.string.sigin), style = Typography.titleMedium.copy(
                    fontSize = 30.sp, color = Color.White, fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.sigin_now), style = Typography.bodyMedium.copy(
                    color = HintColor,
                ), modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .wrapContentWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))


            TextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        text = stringResource(id = R.string.email_address),
                        style = Typography
                            .bodySmall
                            .copy(color = HintColor),
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    cursorColor = HintColor,
                    unfocusedIndicatorColor = HintColor
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = stringResource(id = R.string.password),
                        style = Typography
                            .bodySmall
                            .copy(color = HintColor),
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    cursorColor = HintColor,
                    unfocusedIndicatorColor = HintColor
                ),
                visualTransformation = PasswordVisualTransformation()
            )
        }


    }
}