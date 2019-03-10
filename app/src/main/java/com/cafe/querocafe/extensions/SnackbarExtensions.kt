package com.cafe.querocafe.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.snackbar(text: String, length: Int = Snackbar.LENGTH_LONG): Snackbar =
    Snackbar.make(this, text, length)

