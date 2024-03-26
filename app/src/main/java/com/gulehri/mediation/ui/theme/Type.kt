package com.gulehri.mediation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gulehri.mediation.R


private val alegeryaFamily = FontFamily(Font(R.font.alegreya))
 val alegeryaSansFamily = FontFamily(Font(R.font.alegerya_sans))

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = alegeryaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    titleMedium = TextStyle(
        fontFamily = alegeryaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = alegeryaSansFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = alegeryaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)