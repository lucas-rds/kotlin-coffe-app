package com.cafe.querocafe.extensions.view

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.snackbar(text: String, length: Int = Snackbar.LENGTH_LONG): Snackbar =
    Snackbar.make(this, text, length)

