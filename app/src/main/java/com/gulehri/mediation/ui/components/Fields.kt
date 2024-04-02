package com.gulehri.mediation.ui.components;

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.gulehri.mediation.ui.theme.HintColor
import com.gulehri.mediation.ui.theme.Typography

/*
 * Created by Shahid Iqbal on 3/31/2024.
 */


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediationTextField(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    textStyle: TextStyle = Typography.bodyMedium.copy(Color.White),
    labelText: String,
    labelTextStyle: TextStyle = Typography.bodySmall.copy(color = HintColor),
) {


    BasicTextField2(
        value = value,
        onValueChange = onChange,
        modifier = modifier
            .wrapContentHeight(),
        lineLimits =
        if (isSingleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.MultiLine(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        textStyle = textStyle.copy(color = Color.White),
        enabled = true,
        cursorBrush = SolidColor(HintColor),
        decorator = { innerField ->
            Column {

                if (value.isEmpty())
                    Text(
                        text = labelText,
                        style = labelTextStyle,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp)
                    )
                else innerField()
                Spacer(modifier = Modifier.height(10.dp))

                HorizontalDivider(
                    thickness = 2.dp,
                    color = HintColor
                )
            }
        }

    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediationSecureTextField(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Done,
    textStyle: TextStyle = Typography.bodyMedium.copy(Color.White),
    labelText: String,
    labelTextStyle: TextStyle = Typography.bodySmall.copy(color = HintColor),
) {

    BasicSecureTextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier.wrapContentHeight(),
        textStyle = textStyle,
        imeAction = imeAction,
        textObfuscationMode = TextObfuscationMode.Hidden,
        decorator = {
            Column {

                if (value.isEmpty())
                    Text(
                        text = labelText,
                        style = labelTextStyle,
                        modifier = Modifier.padding(start = 5.dp)
                    )

                Spacer(modifier = Modifier.height(10.dp))

                HorizontalDivider(
                    thickness = 2.dp,
                    color = HintColor
                )
            }
        }
    )
}