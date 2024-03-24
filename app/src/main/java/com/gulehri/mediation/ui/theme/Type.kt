package com.gulehri.mediation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.gulehri.mediation.R


private val alegeryaFamily = FontFamily(Font(R.font.alegreya))
private val alegeryaSansFamily = FontFamily(Font(R.font.alegerya_sans))

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = alegeryaFamily
    ),
    titleMedium = TextStyle(
        fontFamily = alegeryaFamily
    ),
    bodyMedium = TextStyle(
        fontFamily = alegeryaSansFamily
    ),
    bodySmall = TextStyle(
        fontFamily = alegeryaSansFamily
    )
)