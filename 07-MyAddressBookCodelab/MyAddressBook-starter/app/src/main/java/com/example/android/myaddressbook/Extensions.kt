package com.example.android.myaddressbook

import android.graphics.drawable.Drawable
import android.widget.EditText
import android.widget.TextView

internal fun EditText.validateWith
        (passIcon: Drawable?, failIcon: Drawable?,
         validator: (TextView) -> Boolean): Boolean {
    setCompoundDrawablesWithIntrinsicBounds(null, null,
            if (validator(this)) passIcon else failIcon, null)
    return validator(this)
}