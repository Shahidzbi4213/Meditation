package com.gulehri.mediation.ui.components;

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.gulehri.mediation.ui.theme.HintColor
import com.gulehri.mediation.ui.theme.Typography
import com.gulehri.mediation.ui.utils.NoRippleInteractionSource

/*
 * Created by Shahid Iqbal on 3/31/2024.
 */


@Composable
fun MeditationTextField(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    textStyle: TextStyle = Typography.titleMedium.copy(Color.White),
    labelText: String,
    labelTextStyle: TextStyle = Typography.bodySmall.copy(color = HintColor),
) {


    BasicTextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier
            .wrapContentHeight(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        singleLine = isSingleLine,
        textStyle = textStyle.copy(color = Color.White),
        interactionSource = NoRippleInteractionSource(),
        cursorBrush = SolidColor(HintColor),
        visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = {
            it()
            Box {
                Column(modifier = Modifier.padding(top = 5.dp)) {
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
        }


    )
}
