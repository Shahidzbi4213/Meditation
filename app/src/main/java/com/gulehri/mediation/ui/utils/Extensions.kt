package com.gulehri.mediation.ui.utils

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.navigation.compose.rememberNavController
import com.gulehri.mediation.ui.screens.destinations.DirectionDestination
import com.gulehri.mediation.utils.Extension.debug
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo

object Extensions {

    fun DestinationsNavigator.navigateNext(
        current: DirectionDestination,
        next: DirectionDestination,
        canPopup: Boolean,
        inclusive: Boolean,
    ) {
        try {

            if (canPopup) {

                navigate(next) {
                    popUpTo(current) {
                        this.inclusive = inclusive
                    }

                }

            } else navigate(next)


        } catch (e: Exception) {
            e.localizedMessage.debug()
        }
    }


    @SuppressLint("ModifierFactoryUnreferencedReceiver")
    fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
        clickable(indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            onClick()
        }
    }

}