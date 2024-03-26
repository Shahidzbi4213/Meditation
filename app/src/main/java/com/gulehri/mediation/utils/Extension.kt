package com.gulehri.mediation.utils

import android.util.Log

object Extension {

    fun Any?.debug(tag: String = "findMe") {
        Log.d(tag, "$this")
    }
}